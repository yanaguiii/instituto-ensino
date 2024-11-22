package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.UsuarioDao;
import br.com.institutoensino.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/initAdmin")
public class InitAdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioDao usuarioDao = new UsuarioDao();

        // Verifica se já existe algum admin
        if (!usuarioDao.existsAdmin()) {
            // Cria um novo usuário admin
            Usuario adminUser = new Usuario();
            adminUser.setNomeUsuario("Admin");
            adminUser.setEmail("admin@admin.com");
            adminUser.setSenha("senha"); // Use uma senha forte e considere hash
            adminUser.setAdmin(true);

            usuarioDao.createUsuario(adminUser);

            response.getWriter().println("Usuário admin criado com sucesso.");
        } else {
            response.getWriter().println("Já existe um usuário admin.");
        }
    }
}