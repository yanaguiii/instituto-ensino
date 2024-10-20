package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.UsuarioDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-usuario")
public class DeleteUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));

        new UsuarioDao().deleteUsuarioById(idUsuario);

        resp.sendRedirect("/find-all");
    }
}
