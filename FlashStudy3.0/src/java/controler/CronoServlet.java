/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.CronogramaDao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cronograma;
import model.Disciplina;
import model.Usuario;

/**
 *
 * @author Bruno
 */
public class CronoServlet extends HttpServlet {

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

        HttpSession sessao = request.getSession();
        Usuario us = (Usuario) sessao.getAttribute("usuario");

        String minicio = request.getParameter("minicio") + "-01";
        String mfim = request.getParameter("mfim") + "-01";
        String materias = request.getParameter("materias");
        String strURL = "/estudante-cronograma.jsp";

        ArrayList<Disciplina> disciplinas = new ArrayList();
        String[] arrMaterias = materias.split(";");

        Cronograma cronograma = new Cronograma();
        cronograma.setInicio(minicio);
        cronograma.setFim(mfim);
        cronograma.setUsuario(us);

        for (String arrMateria : arrMaterias) {
            Disciplina d = new Disciplina();
            System.out.println(arrMateria);
            d.setNome(arrMateria);
            disciplinas.add(d);
        }

        cronograma.setDisciplinas(disciplinas);

        CronogramaDao dao = new CronogramaDao();
        dao.salvar(cronograma);

        cronograma = dao.getByEmail(us.getEmail());
        
        sessao.setAttribute("cronograma", cronograma);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(strURL);
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
