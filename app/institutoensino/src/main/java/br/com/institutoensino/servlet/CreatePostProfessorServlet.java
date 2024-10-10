package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.PostProfessorDao;
import br.com.institutoensino.model.PostProfessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/create-post-professor")
public class CreatePostProfessorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String conteudo = req.getParameter("post-conteudo");
        String dataStr = req.getParameter("post-data");
        String idProfessorStr = req.getParameter("post-id-professor");
        String idMateriaStr = req.getParameter("post-id-materia");

        try {
            Date data = Date.valueOf(dataStr);
            int idProfessor = Integer.parseInt(idProfessorStr);
            int idMateria = Integer.parseInt(idMateriaStr);

            PostProfessor postProfessor = new PostProfessor(conteudo, data, idProfessor, idMateria);

            new PostProfessorDao().createPostProfessor(postProfessor);

            resp.sendRedirect("/find-all-posts");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid input format.");
            req.getRequestDispatcher("index.html").forward(req, resp);
        }
    }
}
