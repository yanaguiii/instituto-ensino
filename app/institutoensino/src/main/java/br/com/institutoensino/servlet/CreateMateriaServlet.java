package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.MateriaDao;
import br.com.institutoensino.model.Materia;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-materia")
public class CreateMateriaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("materia-nome");
        String idCursoStr = req.getParameter("materia-id-curso");
        String idProfessorStr = req.getParameter("materia-id-professor");

        int idCurso = Integer.parseInt(idCursoStr);
        int idProfessor = Integer.parseInt(idProfessorStr);

        Materia materia = new Materia();
        materia.setNome(nome);
        materia.setIdCurso(idCurso);
        materia.setIdProfessor(idProfessor);

        MateriaDao materiaDao = new MateriaDao();
        materiaDao.createMateria(materia);

        req.getRequestDispatcher("index.html").forward(req, resp);
    }
}
