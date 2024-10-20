package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.PostProfessorDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-post-professor")
public class DeletePostProfessorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idPost = Integer.parseInt(req.getParameter("idPost"));

        new PostProfessorDao().deletePostProfessorById(idPost);

        resp.sendRedirect("/find-all");
    }
}
