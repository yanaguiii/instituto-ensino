package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.ProfessorDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-professor")
public class DeleteProfessorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idProfessor = Integer.parseInt(req.getParameter("idProfessor"));

        new ProfessorDao().deleteProfessorById(idProfessor);

        resp.sendRedirect("/find-all");
    }
}
