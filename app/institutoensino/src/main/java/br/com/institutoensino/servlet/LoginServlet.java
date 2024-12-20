package br.com.institutoensino.servlet;


import br.com.institutoensino.dao.UsuarioDao;
import br.com.institutoensino.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario usuario = usuarioDao.validarLogin(email, password);

        if (usuario != null) {
            // Login bem-sucedido
            request.getSession().setAttribute("usuarioLogado", usuario);
            if (usuario.isAdmin()) {
                response.sendRedirect("/home.jsp");
            } else {
                response.sendRedirect("/home.jsp");
            }
        } else {
            // Falha no login
            request.setAttribute("mensagemErro", "Email ou senha incorretos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}


