
package dao;

/**
 *
 * @author Sergio Aravena
 */

import dto.ProductoDto;


public interface BaseDao {
    
    public boolean agregar(ProductoDto dto);

    public boolean modificar(ProductoDto dto);

    public boolean eliminar(Integer id);

    public ProductoDto buscarPorId(Integer id);
    
}
