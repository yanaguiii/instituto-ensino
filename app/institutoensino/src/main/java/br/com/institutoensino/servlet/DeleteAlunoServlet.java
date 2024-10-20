package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.AlunoDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-aluno")
public class DeleteAlunoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        int idAluno = Integer.parseInt(req.getParameter("idAluno"));

        new AlunoDao().deleteAlunoById(idAluno);

        resp.sendRedirect("/find-all");
    }
}
