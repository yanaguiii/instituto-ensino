package br.com.institutoensino.listener;

import br.com.institutoensino.dao.UsuarioDao;
import br.com.institutoensino.model.Usuario;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AdminInitializerListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Wait for database initialization to complete
        while (!DatabaseInitializer.isDatabaseInitialized) {
            try {
                Thread.sleep(1000); // Wait for 1 second before checking again
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        UsuarioDao usuarioDao = new UsuarioDao();

        if (!usuarioDao.existsAdmin()) {
            Usuario adminUser = new Usuario();
            adminUser.setNomeUsuario("Admin");
            adminUser.setEmail("admin@admin");
            adminUser.setSenha("senha"); // Use uma senha forte e considere hash
            adminUser.setAdmin(true);

            usuarioDao.createUsuario(adminUser);

            System.out.println("Usuário admin criado com sucesso.");
        } else {
            System.out.println("Usuário admin já existe.");
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Não é necessário implementar nada aqui
    }
}