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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            Date nascimento = Date.valueOf(nascimentoStr);
            int numero = Integer.parseInt(numeroStr);

            UsuarioDao usuarioDao = new UsuarioDao();

            if (usuarioDao.emailExiste(email)) {
                req.setAttribute("mensagemErro", "O e-mail já está cadastrado.");

                req.setAttribute("usuarioNome", nome);
                req.setAttribute("usuarioEmail", email);
                req.setAttribute("usuarioSenha", senha);
                req.setAttribute("usuarioNascimento", nascimento);
                req.setAttribute("usuarioRg", rg);
                req.setAttribute("usuarioCpf", cpf);
                req.setAttribute("usuarioLogradouro", logradouro);
                req.setAttribute("usuarioNumero", numero);
                req.setAttribute("usuarioComplemento", complemento);
                req.setAttribute("usuarioBairro", bairro);
                req.setAttribute("usuarioCidade", cidade);
                req.setAttribute("usuarioEstado", estado);
                req.setAttribute("usuarioTelefoneComercial", telefoneComercial);
                req.setAttribute("usuarioCelular", celular);

                req.getRequestDispatcher("cadastro.jsp").forward(req, resp);

            }else {
                Usuario usuario = new Usuario(nome, email, senha, nascimento, cpf, rg, logradouro, numero, complemento, bairro, cidade, estado, telefoneComercial, celular);

                usuarioDao.createUsuario(usuario);

                resp.sendRedirect("login.jsp");
            }

        }catch(NumberFormatException e){
                req.setAttribute("error", "Formato de número inválido.");
                req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
            }catch(IllegalArgumentException e){
                req.setAttribute("error", "Formato de data inválido.");
                req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
            }
        }

}
