<%-- 
    Document   : BuscarPorComprador
    Created on : 08-10-2015, 0:36:01
    Author     : Sergio Aravena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form name="frmBuscadoComprador" action="../BuscarPorComprador" method="POST">
            
            <table border="1">
                <tbody>
                    <tr>
                        <td>Comprador</td>
                        <td><input type="text" name="txtCompradorBuscado" value="" /></td>
                    </tr>
                </tbody>
            </table>

            <hr/>
            
            <input type="submit" value="BuscarComprador" name="btnBuscarComprador" />
            
        </form>
        
    </body>
</html>
