package br.com.institutoensino.servlet;


import br.com.institutoensino.dao.CursoDao;
import br.com.institutoensino.model.Curso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-cursos")
public class ListCursoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CursoDao cursoDao = new CursoDao();
        List<Curso> cursos = cursoDao.findAllCursos();

        req.setAttribute("cursos", cursos);

        req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);

    }
}
