package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.MateriaDao;
import br.com.institutoensino.model.Materia;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-materias")
public class ListMateriaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MateriaDao materiaDao = new MateriaDao();
        List<Materia> materias = materiaDao.findAllMaterias();

        req.setAttribute("materias", materias);
        req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
}
