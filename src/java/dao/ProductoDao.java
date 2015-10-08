
package dao;

/**
 *
 * @author Sergio Aravena
 */

import java.util.List;

import dto.ProductoDto;

public interface ProductoDao extends BaseDao {

    public List<ProductoDto> buscarPorComprador(String comprador);

    public List<ProductoDto> buscarPorRangoPrecio(int min,int max);

    public List<ProductoDto> listarTodos();
    
}
