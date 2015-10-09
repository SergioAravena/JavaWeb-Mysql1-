<%-- 
    Document   : ListarPorComprador
    Created on : 08-10-2015, 0:28:54
    Author     : Sergio Aravena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="dto.ProductoDto" %>

<%@page import="java.util.ArrayList" %>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Displigue de las compras del comprador</title>
    </head>
    <body>
       

        <% 
        
        ArrayList<ProductoDto> lista =
                
                (ArrayList<ProductoDto>)request.getAttribute("listadoComprador");
        
       
        
        %>
        
        
        <table border="1">
            <thead>
                <tr>  
                  
                    <th>ID</th>
                    <th>Nombre Producto</th>
                    <th>Marca Producto</th>
                    <th>Precio Producto</th>
                    <th>Comprador</th>
                </tr>
            </thead>
             <% for(ProductoDto dto : lista) { %>
            <tbody>
                <tr>
                  
        
                    <td><%=dto.getId() %></td>
                    <td><%=dto.getNombreProducto() %></td>
                    <td><%=dto.getMarcaProducto() %></td>
                    <td><%=dto.getPrecio() %></td>
                    <td><%=dto.getComprador()%></td>
                            
                          <% } %>
                </tr>
            </tbody>
        </table>

                         
        
        
        <a href="index.jsp" >HOME</a>
    </body>
</html>
