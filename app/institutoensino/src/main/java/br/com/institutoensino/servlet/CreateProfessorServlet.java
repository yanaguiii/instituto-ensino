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
        String idUsuarioStr = req.getParameter("professor-id-usuario");
        String salarioStr = req.getParameter("professor-salario");

        try {
            int idUsuario = Integer.parseInt(idUsuarioStr);
            BigDecimal salario = new BigDecimal(salarioStr);

            Professor professor = new Professor(idUsuario, salario);

            new ProfessorDao().createProfessor(professor);

            resp.sendRedirect("/find-all-professores");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid input format.");
            req.getRequestDispatcher("index.html").forward(req, resp);
        }
    }
}
