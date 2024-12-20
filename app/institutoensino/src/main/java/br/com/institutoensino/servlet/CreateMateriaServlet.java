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
        String idMateriaStr = req.getParameter("idMateria");
        String nome = req.getParameter("materia-nome");
        String idCursoStr = req.getParameter("materia-id-curso");
        String idProfessorStr = req.getParameter("materia-id-professor");

        try {
            int idCurso = Integer.parseInt(idCursoStr);
            int idProfessor = Integer.parseInt(idProfessorStr);
            MateriaDao materiaDao = new MateriaDao();
            Materia materia;

            if (idMateriaStr == null || idMateriaStr.isBlank()) {
                materia = new Materia(nome, idCurso, idProfessor);
                materiaDao.createMateria(materia);
            } else {
                int idMateria = Integer.parseInt(idMateriaStr);
                materia = new Materia(idMateria, nome, idCurso, idProfessor);
                materiaDao.updateMateria(materia);
            }

            resp.sendRedirect("/find-all");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid input format.");
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }
}
