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
        String matricula = req.getParameter("aluno-matricula");

        try {
            int idUsuario = Integer.parseInt(idUsuarioStr);

            Aluno aluno = new Aluno(idUsuario, matricula);

            new AlunoDao().createAluno(aluno);

            resp.sendRedirect("/find-all-alunos");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid input format.");
            req.getRequestDispatcher("index.html").forward(req, resp);
        }
    }
}
