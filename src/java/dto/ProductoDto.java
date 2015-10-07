
package dto;

/**
 *
 * @author Sergio Aravena
 */
public class ProductoDto {

    private Integer id;
    private String nombreProducto;
    private String marcaProducto;
    private double precio;
    private String comprador;

    public ProductoDto() {
        this.id = 0;
        this.nombreProducto = "";
        this.marcaProducto = "";
        this.precio = 0.0;
        this.comprador = "";
    }
    

    public ProductoDto(Integer id, String nombreProducto, String marcaProducto, double precio, String comprador) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.marcaProducto = marcaProducto;
        this.precio = precio;
        this.comprador = comprador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    @Override
    public String toString() {
        return "ProductoDto{" + "id=" + id + ", nombreProducto=" + nombreProducto + ", marcaProducto=" + marcaProducto + ", precio=" + precio + ", comprador=" + comprador + '}';
    }
    
   
    
    
}
