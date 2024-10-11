package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.UsuarioDao;
import br.com.institutoensino.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Pega os parâmetros do formulário
        String nome = req.getParameter("usuario-nome");
        String email = req.getParameter("usuario-email");
        String senha = req.getParameter("usuario-senha");
        String nascimentoStr = req.getParameter("usuario-nascimento");
        String cpf = req.getParameter("usuario-cpf");
        String rg = req.getParameter("usuario-rg");
        String logradouro = req.getParameter("usuario-logradouro");
        String numeroStr = req.getParameter("usuario-numero");
        String complemento = req.getParameter("usuario-complemento");
        String bairro = req.getParameter("usuario-bairro");
        String cidade = req.getParameter("usuario-cidade");
        String estado = req.getParameter("usuario-estado");
        String telefoneComercial = req.getParameter("usuario-telefone-comercial");
        String celular = req.getParameter("usuario-celular");

        try {
            // Conversão de parâmetros que podem gerar exceções
            Date nascimento = Date.valueOf(nascimentoStr);
            int numero = Integer.parseInt(numeroStr);

            UsuarioDao usuarioDao = new UsuarioDao();

            // Verifica se o e-mail já está cadastrado
            if (usuarioDao.emailExiste(email)) {
                // Se o e-mail já existe, define a mensagem de erro e redireciona para a página de cadastro
                req.setAttribute("mensagemErro", "O e-mail já está cadastrado.");
                req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
            } else {
                // Se o e-mail não existe, cria um novo usuário
                Usuario usuario = new Usuario(nome, email, senha, nascimento, cpf, rg, logradouro, numero, complemento, bairro, cidade, estado, telefoneComercial, celular);

                // Insere o novo usuário no banco de dados
                usuarioDao.createUsuario(usuario);

                // Redireciona para a página de login após o cadastro
                resp.sendRedirect("login.jsp");
            }

        } catch (NumberFormatException e) {
            // Se ocorrer uma exceção de conversão, define uma mensagem de erro e redireciona para a página de cadastro
            req.setAttribute("error", "Formato de número inválido.");
            req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
        } catch (IllegalArgumentException e) {
            // Se ocorrer uma exceção relacionada ao formato da data, define uma mensagem de erro e redireciona para a página de cadastro
            req.setAttribute("error", "Formato de data inválido.");
            req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
        }
    }
}
