package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.AlunoDao; // Certifique-se de que existe um AlunoDao
import br.com.institutoensino.model.Aluno; // Certifique-se de que existe um Aluno

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-alunos")
public class ListAlunoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AlunoDao alunoDao = new AlunoDao();
        List<Aluno> alunos = alunoDao.findAllAlunos();

        req.setAttribute("alunos", alunos);
        req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
}
