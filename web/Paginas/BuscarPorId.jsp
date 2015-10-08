<%-- 
    Document   : BuscarPorId
    Created on : 08-10-2015, 0:09:35
    Author     : Sergio Aravena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BuscarPorId</title>
    </head>
    <body>
  
        <form name="frmBuscarID" action="../BuscarPorId" method="POST">
            
            <b>ID</b>
            <table border="1">
                
                <tbody>
                    <tr>
                        <td>Id a Buscar</td>
                        <td><input type="text" name="txtIDBuscar" value="" /></td>
                    </tr>
                </tbody>
            </table>

            <hr/>
            
            <input type="submit" value="BuscarPorID" name="btnBuscarId" />
            
        </form>
        <a href="../index.jsp" >HOME</a>
        
    </body>
</html>
