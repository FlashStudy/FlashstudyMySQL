/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @author FBQ-DEV2
 */
public class executar_login extends HttpServlet {

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
        PrintWriter out;
        response.setContentType("text/html");
        out = response.getWriter();

        out.println("<html>");

        out.println("<head>");
        out.println("<title>Flashstudy</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("<p style = 'text-align: center;'>..Sessão encerrada..");
        out.println("<br><br>Obrigado e até logo!");
        out.println("<br><br><a href = 'index.jsp'>Voltar para a tela inicial</a>");
        out.println("</p>");

        HttpSession sessao = request.getSession();
        sessao.invalidate();

        out.println("</body>");

        out.println("</html>");

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
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sessao = request.getSession();

        Usuario us;

        UsuarioDao dao = new UsuarioDao();
        String email;
        String senha;
        String nome;
        String acao = request.getParameter("acao");

        String strURL0 = "/estudante-inicial.jsp";
        String strURL1 = "/index.jsp";

        if (acao.equals("login")) {
            email = request.getParameter("email");
            senha = request.getParameter("senha");

            us = dao.procuraEmail(email);

            if ((!us.getSenha().equals(senha) || us.getEmail().equals("")) || us.getEmail() == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(strURL1);
                dispatcher.forward(request, response);
            } else {
                sessao.setAttribute("usuario_logado", "true");
                sessao.setAttribute("usuario", us);

                RequestDispatcher dispatcher = request.getRequestDispatcher(strURL0);
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

            sessao.setAttribute("usuario_logado", "true");
            sessao.setAttribute("usuario", us);

            if (resultado == 0) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(strURL0);
                dispatcher.forward(request, response);
            }
        }
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
