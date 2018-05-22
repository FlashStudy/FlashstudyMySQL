/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.FlashcardDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Flashcard;
import model.Usuario;

/**
 *
 * @author FBQ-DEV2
 */
public class FlashcardServlet extends HttpServlet {

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

        Usuario us = new Usuario();
        us.setEmail(request.getParameter("email"));

        String publico = request.getParameter("publico") != null
                ? request.getParameter("publico") : "";
        String titulo = request.getParameter("titulo");
        String pergunta = request.getParameter("pergunta");
        String resposta = request.getParameter("resposta");

        Flashcard card = new Flashcard();
        card.setPergunta(pergunta);
        card.setTitulo(titulo);
        card.setResposta(resposta);

        if (publico.equals("Público")) {
            card.setPublico("Público");
        } else {
            card.setPublico("Privado");
        }

        card.setUsuario(us);

        FlashcardDao dao = new FlashcardDao();

        int aux = dao.salvar(card);

        if (aux == 0) {
            request.setAttribute("salvo", "salvo");
        } else {
            request.setAttribute("salvo", "erro");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("estudante-flashcards.jsp");
        dispatcher.forward(request, response);
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
