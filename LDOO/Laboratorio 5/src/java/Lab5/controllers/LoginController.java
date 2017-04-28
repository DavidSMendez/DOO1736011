/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Lab5.models.User;
import Lab5.models.Authentication;
import java.util.Set;
import java.util.HashSet;
import javax.servlet.http.HttpSession;
/**
 *
 * @author david
 */
public class LoginController extends HttpServlet {

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

       HttpSession session = request.getSession();
    //Se recupera la información del request
    String txtUsername = request.getParameter("username");
    String txtPassword = request.getParameter("password");

    //Invoca al método authenticate para validar el usuario
    boolean isValidUser =  Authentication.authenticate(txtUsername, txtPassword);

    if(isValidUser) {

        //Construye instancia del modelo User
        User user = new User(txtUsername, txtPassword);
        session.setAttribute("username", user.getUsername());
        response.sendRedirect("success.jsp");
    }
    else {
        //Si el usuario es inválido, reedireccionamos la petición hacia error.jsp
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
