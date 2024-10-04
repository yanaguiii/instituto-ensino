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
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/create-usuario")
public class CreateUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("usuario-nome");
        String email = req.getParameter("usuario-email"); // Ajuste aqui
        String senha = req.getParameter("usuario-senha"); // Ajuste aqui
        String nascimentoStr = req.getParameter("usuario-nascimento"); // Ajuste aqui
        String cpf = req.getParameter("usuario-cpf"); // Ajuste aqui
        String rg = req.getParameter("usuario-rg"); // Ajuste aqui
        String logradouro = req.getParameter("usuario-logradouro"); // Ajuste aqui
        String numeroStr = req.getParameter("usuario-numero"); // Ajuste aqui
        String complemento = req.getParameter("usuario-complemento"); // Ajuste aqui
        String bairro = req.getParameter("usuario-bairro"); // Ajuste aqui
        String cidade = req.getParameter("usuario-cidade"); // Ajuste aqui
        String estado = req.getParameter("usuario-estado"); // Ajuste aqui
        String telefoneComercial = req.getParameter("usuario-telefone-comercial"); // Ajuste aqui
        String celular = req.getParameter("usuario-celular"); // Ajuste aqui

        Date nascimento = null;
        int numero = 0;
        boolean isValid = true;

        if (nascimentoStr != null && !nascimentoStr.isEmpty()) {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd"); // Formato de data do input type="date"
            java.util.Date utilDate;

            try {
                utilDate = inputFormat.parse(nascimentoStr);
                nascimento = new Date(utilDate.getTime());
            } catch (ParseException e) {
                req.setAttribute("error", "Formato de data inválido. Use YYYY-MM-DD.");
                isValid = false;
            }
        } else {
            req.setAttribute("error", "Data de nascimento não pode ser vazia.");
            isValid = false;
        }

        if (numeroStr != null && !numeroStr.isEmpty()) {
            try {
                numero = Integer.parseInt(numeroStr);
            } catch (NumberFormatException e) {
                req.setAttribute("error", "Número deve ser um valor inteiro.");
                isValid = false;
            }
        } else {
            req.setAttribute("error", "Número não pode ser vazio.");
            isValid = false;
        }

        if (!isValid) {
            req.getRequestDispatcher("index.html").forward(req, resp);
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setNascimento(nascimento);
        usuario.setCpf(cpf);
        usuario.setRg(rg);
        usuario.setLogradouro(logradouro);
        usuario.setNumero(numero);
        usuario.setComplemento(complemento);
        usuario.setBairro(bairro);
        usuario.setCidade(cidade);
        usuario.setEstado(estado);
        usuario.setTelefoneComercial(telefoneComercial);
        usuario.setCelular(celular);

        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.createUsuario(usuario);

        req.getRequestDispatcher("index.html").forward(req, resp);
    }
}
