package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.CursoDao;
import br.com.institutoensino.model.Curso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/find-curso-by-id")
public class ListCursoByIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cursoIdParam = req.getParameter("idCurso");

        if (cursoIdParam != null && !cursoIdParam.isEmpty()) {
            try {
                int idCurso = Integer.parseInt(cursoIdParam);
                CursoDao cursoDao = new CursoDao();
                Curso curso = cursoDao.getCursoById(idCurso);

                if (curso != null) {
                    req.setAttribute("curso", curso);
                    req.getRequestDispatcher("/aluno").forward(req, resp);
                } else {
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Curso not found");
                }
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid curso ID format");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Curso ID is required");
        }
    }
}