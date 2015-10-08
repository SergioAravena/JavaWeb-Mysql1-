
package dao;

/**
 *
 * @author Sergio Aravena
 */
import sql.Conexion;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import dto.ProductoDto;

public class ProductoDaoImplementado  implements ProductoDao{

    @Override
    public List<ProductoDto> buscarPorComprador(String comprador) {
        List<ProductoDto> listado = new ArrayList<ProductoDto>();

        try {

            Connection conexion = Conexion.getConexion();

            String query = "SELECT * FROM producto WHERE pr_comprador = ? ";

            PreparedStatement listar = conexion.prepareStatement(query);

            listar.setString(1, comprador);

            ResultSet rs = listar.executeQuery();

            while (rs.next()) {

                ProductoDto dto = new ProductoDto();

                dto.setId(rs.getInt("pr_Id"));
                dto.setNombreProducto(rs.getString("pr_nombreProducto"));
                dto.setMarcaProducto(rs.getString("pr_marcaProducto"));
                dto.setPrecio(rs.getDouble("pr_precio"));
                dto.setComprador(rs.getString("pr_comprador"));

                listado.add(dto);

            }
            
            listar.close();
            conexion.close();
            
            
        } catch(SQLException w){
            System.out.println("Error en la conexion sql "+w.getMessage());
            
        } catch (Exception e) {
            
            System.out.println("Error al listar los productos por comprador "+e.getMessage());
            
        }
        
        return  listado;
    }

    @Override
    public List<ProductoDto> buscarPorRangoPrecio(int min, int  max) {
        
       List<ProductoDto> listado = new ArrayList<ProductoDto>();
       
       
        try {
            Connection conexion = Conexion.getConexion();
            
            String query = "SELECT * FROM producto WHERE pr_precio BETWEEN  ? AND ? "+
                          "ORDER BY pr_precio DESC";
            
            PreparedStatement rango = conexion.prepareStatement(query);
            
            rango.setInt(1, min);
            rango.setInt(2, max);
            
            ResultSet rs = rango.executeQuery();
            
            while(rs.next()){
                
                ProductoDto dto = new ProductoDto();
                
                dto.setId(rs.getInt("pr_id"));
                dto.setNombreProducto(rs.getString("pr_nombreProducto"));
                dto.setMarcaProducto(rs.getString("pr_marcaProducto"));
                dto.setPrecio(rs.getDouble("pr_precio"));
                dto.setComprador(rs.getString("pr_comprador"));

                
                listado.add(dto);
            }
            
               rango.close();
               conexion.close();
            
            
        } catch(SQLException w){ 
            
            System.out.println("Error en la conexion sql "+w.getMessage());
        } catch (Exception e) {
            
            System.out.println("Error en  el listar por el rango de precio "+e.getMessage());
            
        }
        
        return listado;
    }

    @Override
    public List<ProductoDto> listarTodos() {
        List<ProductoDto> listado = new ArrayList<ProductoDto>();
        
        try {
            Connection conexion = Conexion.getConexion();
            String query = "SELECT * FROM PRODUCTO ";
            
            PreparedStatement listar = conexion.prepareStatement(query);
            
            ResultSet rs = listar.executeQuery();
            
            while(rs.next()){
                ProductoDto dto = new ProductoDto();
                
                dto.setId(rs.getInt("pr_id"));
                dto.setNombreProducto(rs.getString("pr_nombreProducto"));
                dto.setMarcaProducto(rs.getString("pr_marcaProducto"));
                dto.setPrecio(rs.getDouble("pr_precio"));
                dto.setComprador(rs.getString("pr_comprador"));
                
                listado.add(dto);
                
            }
            
            listar.close();
            conexion.close();
            
        } catch(SQLException w){  
            System.out.println("Error en la conexion sql "+w.getMessage());
        } catch (Exception e) {
            System.out.println("Error en el listarTodos los producto "+e.getMessage());
        }
        
        return listado;
    }

    @Override
    public boolean agregar(ProductoDto dto) {
        
        try {
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO producto (pr_nombreProducto,pr_marcaProducto,pr_precio,pr_comprador)"+
                    "VALUES (?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(query);
            
            insertar.setString(1, dto.getNombreProducto());
            insertar.setString(2, dto.getMarcaProducto());
            insertar.setDouble(3, dto.getPrecio());
            insertar.setString(4, dto.getComprador());
            
            insertar.execute();
            insertar.close();
            conexion.close();
            
            
            
             return true; 
            
            
        }catch(SQLException w){
            
            System.out.println("Error en la conexion Sql "+w.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error al agregar el prodcuto "+e.getMessage());
          return false;
        }
      
    }

    @Override
    public boolean modificar(ProductoDto dto) {
        
        try {
            
            Connection conexion = Conexion.getConexion();
            
            String query = "UPDATE producto set pr_nombreProducto = ?,pr_marcaProducto = ?,"+
                    "pr_precio = ? , pr_comprador = ? WHERE pr_id = ? ";
            
            
            PreparedStatement actualizar = conexion.prepareStatement(query);
            
           actualizar.setString(1, dto.getNombreProducto());
           actualizar.setString(2, dto.getMarcaProducto());
           actualizar.setDouble(3, dto.getPrecio());
           actualizar.setString(4, dto.getComprador());
           
           actualizar.executeUpdate();
           
           actualizar.close();
           conexion.close();
           
            return true;
        }catch(SQLException w){ 
            System.out.println("Error en la conexion sql"+w.getMessage());
            return false;
        } catch (Exception e) {
            
            System.out.println("Error al modificar el producto "+e.getMessage());
            return false;
        }
        
        
    }

    @Override
    public boolean eliminar(Integer id) {
       
        try {
 
            Connection conexion = Conexion.getConexion();

            String query = "DELETE FROM producto WHERE pr_id = ?";

            PreparedStatement borrar = conexion.prepareStatement(query);

            borrar.setInt(1, id);

            borrar.execute();

            borrar.close();

            conexion.close();

            
            return true;
            
              } catch (SQLException w) {
                
               System.out.println("Error en la conexion sql "+w.getMessage());   
                  
            return false;
        } catch (Exception e) {

            System.out.println("Error al eliminar el producto "+e.getMessage());
            return false;
        }

    }

    @Override
    public ProductoDto buscarPorId(Integer id) {
        ProductoDto dto = null;
        
        try {
           Connection conexion = Conexion.getConexion();
           
           String query = "SELECT * FROM PRODUCTO WHERE pr_id = ?";
           
           PreparedStatement buscarId = conexion.prepareStatement(query);
           
           buscarId.setInt(1, id);
           
           ResultSet rs = buscarId.executeQuery();
           
           
           while(rs.next()){
               
               dto = new ProductoDto();
               
               dto.setId(rs.getInt("pr_id"));
               dto.setNombreProducto(rs.getString("pr_nombreProducto"));
               dto.setMarcaProducto(rs.getString("pr_marcaProducto"));
               dto.setPrecio(rs.getDouble("pr_precio"));
               dto.setComprador(rs.getString("pr_comprador"));
           
           }
           buscarId.close();
           conexion.close();
           
            
        } catch (SQLException w) {

            System.out.println("Error en la conexion sql " + w.getMessage());
        } catch (Exception e) {

            System.out.println("Error al buscar por id el producto  " + e.getMessage());
        }
        
        return dto;
    }
    
}
