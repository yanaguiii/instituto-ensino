package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.ProfessorDao;
import br.com.institutoensino.model.Professor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-professores")
public class ListProfessorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProfessorDao professorDao = new ProfessorDao();
        List<Professor> professores = professorDao.findAllProfessores();

        req.setAttribute("professores", professores);
        req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
}
