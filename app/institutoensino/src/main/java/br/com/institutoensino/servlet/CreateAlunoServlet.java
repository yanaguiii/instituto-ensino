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
        String idUsuarioStr = req.getParameter("aluno-id-usuario"); // Ajuste aqui
        String matricula = req.getParameter("aluno-matricula");

        int idUsuario = Integer.parseInt(idUsuarioStr);

        Aluno aluno = new Aluno();
        aluno.setIdUsuario(idUsuario);
        aluno.setMatricula(matricula);

        AlunoDao alunoDao = new AlunoDao();
        alunoDao.createAluno(aluno);

        req.getRequestDispatcher("index.html").forward(req, resp);
    }
}
