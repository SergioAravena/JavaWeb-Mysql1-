
package dao;

/**
 *
 * @author Sergio Aravena
 */
import sql.Conexion;
import java.sql.*;
import java.util.List;
import  dao.*;
import dto.ProductoDto;

public class ProductoDaoImplementado  implements ProductoDao{

    @Override
    public List<ProductoDto> buscarPorComprador(String comprador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductoDto> buscarPorRangoPrecio(int min, int max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductoDto> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductoDto buscarPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
