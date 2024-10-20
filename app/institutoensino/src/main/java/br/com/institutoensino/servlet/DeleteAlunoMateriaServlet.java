package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.AlunoMateriaDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-aluno-materia")
public class DeleteAlunoMateriaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idAluno = Integer.parseInt(req.getParameter("idAlunoMateria"));
        int idMateria = Integer.parseInt(req.getParameter("idMateriaAluno"));

        new AlunoMateriaDao().deleteAlunoMateriaById(idAluno, idMateria);

        resp.sendRedirect("/find-all");
    }
}
