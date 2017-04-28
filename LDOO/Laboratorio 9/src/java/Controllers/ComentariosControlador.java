
package Controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ComentariosDAO;
import models.ComentariosPOJO;

/**
 *
 * @author david
 */
public class ComentariosControlador extends HttpServlet {
    private Object session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session =request.getSession();
        
        ComentariosDAO dao = new ComentariosDAO();
        ComentariosPOJO dto = new ComentariosPOJO();  
        
        String action = request.getParameter("action");
        String nombre = request.getParameter("nombre");
        String comentario = request.getParameter("comentario");
                
        dto.setNombre(nombre);
        dto.setComentario(comentario);
        
        if(action.equals("comentar")){
            dao.insertar(dto);
            response.sendRedirect("buscar.jsp");
        }
        
        if(action.equals("buscar")){
            ArrayList <ComentariosPOJO> comentarios = dao.buscar(dto);
            session.setAttribute("comentarios", comentarios);
            response.sendRedirect("buscar.jsp");
        }
        if(!"comentar".equals(action) & !"buscar".equals(action)){
            response.sendRedirect("error.jsp");
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
