/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.UsuarioDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author Aluno
 */
public class UsuarioServlet extends HttpServlet {

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
        Usuario us;

        UsuarioDao dao = new UsuarioDao();
        String email;
        String senha;
        String nome;
        String acao = request.getParameter("acao");

        if (acao.equals("login")) {
            email = request.getParameter("email");
            senha = request.getParameter("senha");

            us = dao.procuraEmail(email);

            request.setAttribute("Usuario", us);

            if (!us.getEmail().equals("") && us.getEmail() != null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("estudante-inicial.jsp");
                dispatcher.forward(request, response);
            }
        }

        if (acao.equals("cadastro")) {
            nome = request.getParameter("nome");
            email = request.getParameter("email");
            senha = request.getParameter("senha");

            us = new Usuario(email, nome, senha);

            int resultado;
            resultado = dao.salvar(us);

            request.setAttribute("Usuario", us);

            if (resultado == 0) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("estudante-inicial.jsp");
                dispatcher.forward(request, response);
            }
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
