
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dto.ProductoDto;

import dao.*;

import java.util.List;

/**
 *
 * @author Sergio Aravena
 */
public class BuscarPorComprador extends HttpServlet {

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
            
            String nombre = request.getParameter("txtCompradorBuscado".trim());
            
            List<ProductoDto> lista = new ProductoDaoImplementado().buscarPorComprador(nombre);
            
            
            
            
            //*** el punto importante ahora es que es que esta coleccion
            //sea enviada a un jsp para su desplige 
            //propuesto : investigue como cargar el arreglo 
            //propio de los servlet para luego enviar 
            // informacion a un jsp 
            
            /**
             * Para enviar la lista a desplegar en un jsp necesitamos cargarla
             * en una variable, para esto settiamos el request
             */

            request.setAttribute("listadoComprador", lista);
            
            //ahora redireccionamos al jsp para el despliegue
            //OJO le decimos donde ir y cargamos el request
            
            request.getRequestDispatcher("Paginas/ListarPorComprador.jsp")
                  .forward(request, response);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BuscarPorComprador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuscarPorComprador at " + request.getContextPath() + "</h1>");
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
