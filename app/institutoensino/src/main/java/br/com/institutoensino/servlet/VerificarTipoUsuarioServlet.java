package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.UsuarioDao;
import br.com.institutoensino.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/verificarTipoUsuario")
public class VerificarTipoUsuarioServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        response.setContentType("text/plain");

        if (session != null && session.getAttribute("usuarioLogado") != null) {
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
            int idUsuario = usuarioLogado.getIdUsuario();

            UsuarioDao usuarioDao = new UsuarioDao();
            String tipoUsuario = usuarioDao.verificarTipoUsuario(idUsuario);

            if ("ALUNO".equals(tipoUsuario)) {
                // Redirecionar para aluno.jsp com o idUsuario como parâmetro
                response.getWriter().write("aluno.jsp?idUsuario=" + idUsuario);
            } else if ("PROFESSOR".equals(tipoUsuario)) {
                // Redirecionar para professor.jsp com o idUsuario como parâmetro
                response.getWriter().write("professor.jsp?idUsuario=" + idUsuario);
            } else {
                response.getWriter().write("home.jsp");
            }
        } else {
            response.getWriter().write("login.jsp");
        }
    }
}

