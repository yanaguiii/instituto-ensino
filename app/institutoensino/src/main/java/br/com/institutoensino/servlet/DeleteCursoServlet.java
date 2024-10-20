package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.CursoDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-curso")
public class DeleteCursoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idCurso = Integer.parseInt(req.getParameter("idCurso"));

        new CursoDao().deleteCursoById(idCurso);

        resp.sendRedirect("/find-all");
    }
}
