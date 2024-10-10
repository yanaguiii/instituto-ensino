package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.PostProfessorDao;
import br.com.institutoensino.model.PostProfessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-post-professores")
public class ListPostProfessorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostProfessorDao postProfessorDao = new PostProfessorDao();
        List<PostProfessor> postProfessores = postProfessorDao.findAllPostProfessores();

        req.setAttribute("postProfessores", postProfessores);
        req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
}
