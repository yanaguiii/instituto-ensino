package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.CursoDao;
import br.com.institutoensino.model.Curso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-curso")
public class CreateCursoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idCursoStr = req.getParameter("idCurso");
        String cursoNome = req.getParameter("curso-nome");
        String cursoModalidade = req.getParameter("curso-modalidade");
        String cursoDuracaoStr = req.getParameter("curso-duracao");
        String cursoCampus = req.getParameter("curso-campus");
        String cursoTurno = req.getParameter("curso-turno");
        String cursoDescricao = req.getParameter("curso-descricao");

        try {
            float cursoDuracao = Float.parseFloat(cursoDuracaoStr);
            CursoDao cursoDao = new CursoDao();
            Curso curso;

            if (idCursoStr == null || idCursoStr.isBlank()) {
                curso = new Curso(cursoNome, cursoModalidade, cursoDuracao, cursoCampus, cursoTurno, cursoDescricao);
                cursoDao.createCurso(curso);
            } else {
                int idCurso = Integer.parseInt(idCursoStr);
                curso = new Curso(idCurso, cursoNome, cursoModalidade, cursoDuracao, cursoCampus, cursoTurno, cursoDescricao);
                cursoDao.updateCurso(curso);
            }

            resp.sendRedirect("/find-all");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Formato de duração inválido.");
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }
}


