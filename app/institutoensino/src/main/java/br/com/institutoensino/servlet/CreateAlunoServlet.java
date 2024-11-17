package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.AlunoDao;
import br.com.institutoensino.model.Aluno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-aluno")
public class CreateAlunoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idUsuarioStr = req.getParameter("aluno-id-usuario");

        try {
            int idUsuario = Integer.parseInt(idUsuarioStr);
            AlunoDao alunoDao = new AlunoDao();
            Aluno aluno;
            
                aluno = new Aluno(idUsuario);
                alunoDao.createAluno(aluno);


            resp.sendRedirect("/find-all");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Formato de entrada inválido.");
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }
}

