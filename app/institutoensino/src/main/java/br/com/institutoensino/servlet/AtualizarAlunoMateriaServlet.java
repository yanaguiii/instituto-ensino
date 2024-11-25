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

@WebServlet("/atualizar-aluno-materia")
public class AtualizarAlunoMateriaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idAlunoStr = req.getParameter("aluno-materia-id-aluno");
        String idMateriaStr = req.getParameter("aluno-materia-id-materia");
        String notaStr = req.getParameter("aluno-materia-nota");
        String faltasStr = req.getParameter("aluno-materia-faltas");

        resp.setContentType("text/plain");

        try {
            int idAluno = Integer.parseInt(idAlunoStr);
            int idMateria = Integer.parseInt(idMateriaStr);
            BigDecimal nota = new BigDecimal(notaStr);
            int faltas = Integer.parseInt(faltasStr);

            AlunoMateriaDao alunoMateriaDao = new AlunoMateriaDao();
            AlunoMateria alunoMateria = new AlunoMateria(idAluno, idMateria, nota, faltas);

            if (alunoMateriaDao.existsByIds(idAluno, idMateria)) {
                alunoMateriaDao.updateAlunoMateria(alunoMateria);
            } else {
                alunoMateriaDao.createAlunoMateria(alunoMateria);
            }

            resp.getWriter().write("success");
        } catch (NumberFormatException e) {
            resp.getWriter().write("Erro: Formato de entrada inválido.");
        } catch (Exception e) {
            resp.getWriter().write("Erro: " + e.getMessage());
        }
    }
}




