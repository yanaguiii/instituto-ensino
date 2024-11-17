package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.CursoDao;
import br.com.institutoensino.model.Curso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/find-curso-by-nome")
public class ListCursoByNomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cursoNome = req.getParameter("curso-nome");

        if (cursoNome != null && !cursoNome.isEmpty()) {
            CursoDao cursoDao = new CursoDao();
            Curso curso = cursoDao.getCursoByNome(cursoNome);

            if (curso != null) {
                req.setAttribute("curso", curso);
                req.getRequestDispatcher("cadastro.jsp").forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Curso not found");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Curso name is required");
        }
    }
}