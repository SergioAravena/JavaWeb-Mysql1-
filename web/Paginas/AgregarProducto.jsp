<%-- 
    Document   : AgregarProducto
    Created on : 07-10-2015, 23:17:31
    Author     : Sergio Aravena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar producto </title>
    </head>
    <body>
      
        <form name="frmAgregarProductoDto" action="../AgregarProducto" method="POST">
            
            <table border="1">
               
                <tbody>
                    <tr>
                        <td>nombreProducto</td>
                        <td><input type="text" name="txtNombreProducto" value="" /></td>
                    </tr>
                    <tr>
                        <td>marcaProducto</td>
                        <td><input type="text" name="txtMarcaProducto" value="" /></td>
                    </tr>
                    <tr>
                        <td>Precio</td>
                        <td><input type="text" name="txtPrecioProducto" value="" /></td>
                    </tr>
                    <tr>
                        <td>Comprador</td>
                        <td><input type="text" name="txtComprador" value="" /></td>
                    </tr>
                </tbody>
            </table>

            <br/>

            <input type="submit" value="Ingresar" name="btnIngreso" />
            
        </form>
        
        <a href="../index.jsp" >HOME</a>
        
    </body>
</html>
