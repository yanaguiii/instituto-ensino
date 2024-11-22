package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.AlunoDao;
import br.com.institutoensino.dao.PostProfessorDao;
import br.com.institutoensino.model.PostProfessor;
import br.com.institutoensino.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/buscarPostsAluno")
public class BuscarPostsAlunoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("usuarioLogado") != null) {
            int idUsuario = ((Usuario) session.getAttribute("usuarioLogado")).getIdUsuario();

            AlunoDao alunoDao = new AlunoDao();
            PostProfessorDao postProfessorDao = new PostProfessorDao();

            int idAluno = alunoDao.getIdAlunoByIdUsuario(idUsuario);
            List<Integer> idMaterias = alunoDao.buscarIdMateriasPorAluno(idAluno);
            List<PostProfessor> posts = postProfessorDao.buscarPostsPorMaterias(idMaterias);

            request.setAttribute("posts", posts);
            request.getRequestDispatcher("aluno.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}