
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductoDto;

import dao.*;




/**
 *
 * @author Sergio Aravena
 */
public class AgregarProducto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
            ProductoDto dto = new ProductoDto();
            
            dto.setNombreProducto(request.getParameter("txtNombreProducto".trim()));
            dto.setMarcaProducto(request.getParameter("txtMarcaProducto".trim()));
            dto.setPrecio(Double.parseDouble(request.getParameter("txtPrecioProducto".trim())));
            dto.setComprador(request.getParameter("txtComprador"));
            
            new dao.ProductoDaoImplementado().agregar(dto);
            
            response.sendRedirect("Paginas/AgregarProducto.jsp");

//               response.containsHeader("Agregado el Producto");
//               response.getHeader("Agregado");
//               response.setContentType("asajshja");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarProducto at " + request.getContextPath() + "</h1>");
            out.println("<span>Producto agregado</span>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
