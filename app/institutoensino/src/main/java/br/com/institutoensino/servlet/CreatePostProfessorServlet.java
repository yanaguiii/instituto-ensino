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
        String idPostStr = req.getParameter("idPost");
        String conteudo = req.getParameter("post-conteudo");
        String dataStr = req.getParameter("post-data");
        String idProfessorStr = req.getParameter("post-id-professor");
        String idMateriaStr = req.getParameter("post-id-materia");

        try {
            Date data = Date.valueOf(dataStr);
            int idProfessor = Integer.parseInt(idProfessorStr);
            int idMateria = Integer.parseInt(idMateriaStr);
            PostProfessorDao postProfessorDao = new PostProfessorDao();
            PostProfessor postProfessor;

            if (idPostStr == null || idPostStr.isBlank()) {
                // Criação de um novo post se o idPost não estiver presente ou estiver em branco
                postProfessor = new PostProfessor(conteudo, data, idProfessor, idMateria);
                postProfessorDao.createPostProfessor(postProfessor);
            } else {
                // Atualização do post existente se o idPost estiver presente
                int idPost = Integer.parseInt(idPostStr);
                postProfessor = new PostProfessor(idPost, conteudo, data, idProfessor, idMateria);
                postProfessorDao.updatePostProfessor(postProfessor);
            }

            resp.sendRedirect("/find-all");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid input format.");
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }
}

