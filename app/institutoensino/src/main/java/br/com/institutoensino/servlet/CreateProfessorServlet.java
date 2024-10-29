package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.ProfessorDao;
import br.com.institutoensino.model.Professor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/create-professor")
public class CreateProfessorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idProfessorStr = req.getParameter("idProfessor");
        String idUsuarioStr = req.getParameter("professor-id-usuario");
        String salarioStr = req.getParameter("professor-salario");

        try {
            int idUsuario = Integer.parseInt(idUsuarioStr);
            double salario = Double.parseDouble(salarioStr);
            ProfessorDao professorDao = new ProfessorDao();
            Professor professor;

            if (idProfessorStr == null || idProfessorStr.isBlank()) {
                professor = new Professor(idUsuario, salario);
                professorDao.createProfessor(professor);
            } else {
                int idProfessor = Integer.parseInt(idProfessorStr);
                professor = new Professor(idProfessor, idUsuario, salario);
                professorDao.updateProfessor(professor);
            }

            resp.sendRedirect("/find-all");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid input format.");
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }
}
