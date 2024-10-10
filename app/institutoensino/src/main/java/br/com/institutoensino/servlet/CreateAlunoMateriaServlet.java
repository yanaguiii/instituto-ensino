package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.AlunoMateriaDao;
import br.com.institutoensino.model.AlunoMateria;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/create-aluno-materia")
public class CreateAlunoMateriaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idAlunoStr = req.getParameter("aluno-materia-id-aluno");
        String idMateriaStr = req.getParameter("aluno-materia-id-materia");
        String notaStr = req.getParameter("aluno-materia-nota");
        String faltasStr = req.getParameter("aluno-materia-faltas");

        try {
            int idAluno = Integer.parseInt(idAlunoStr);
            int idMateria = Integer.parseInt(idMateriaStr);
            BigDecimal nota = new BigDecimal(notaStr);
            int faltas = Integer.parseInt(faltasStr);

            AlunoMateria alunoMateria = new AlunoMateria(idAluno, idMateria, nota, faltas);

            new AlunoMateriaDao().createAlunoMateria(alunoMateria);

            resp.sendRedirect("/find-all-alunos-materias");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid input format.");
            req.getRequestDispatcher("index.html").forward(req, resp);
        }
    }
}


