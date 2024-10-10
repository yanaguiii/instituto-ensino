package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.AlunoMateriaDao;
import br.com.institutoensino.model.AlunoMateria;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-aluno-materias")
public class ListAlunoMateriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AlunoMateriaDao alunoMateriaDao = new AlunoMateriaDao();
        List<AlunoMateria> alunoMaterias = alunoMateriaDao.findAllAlunoMaterias();

        req.setAttribute("alunoMaterias", alunoMaterias);
        req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
}
