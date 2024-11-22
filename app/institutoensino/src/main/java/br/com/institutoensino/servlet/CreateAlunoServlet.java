package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.AlunoDao;
import br.com.institutoensino.model.Aluno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-aluno")
public class CreateAlunoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idAlunoStr = req.getParameter("idAluno");
        String idUsuarioStr = req.getParameter("aluno-id-usuario");
        String idCursoStr = req.getParameter("aluno-id-curso");

        try {
            int idUsuario = Integer.parseInt(idUsuarioStr);
            int idCurso = Integer.parseInt(idCursoStr);
            AlunoDao alunoDao = new AlunoDao();
            Aluno aluno;

            if (idAlunoStr == null || idAlunoStr.isBlank()) {
                // Create new Aluno if idAluno is not present
                aluno = new Aluno(idUsuario, idCurso);
                alunoDao.createAluno(aluno);
            } else {
                // Update existing Aluno if idAluno is present
                int idAluno = Integer.parseInt(idAlunoStr);
                aluno = new Aluno(idAluno, idUsuario, idCurso);
                alunoDao.updateAluno(aluno);
            }

            resp.sendRedirect("/find-all");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Formato de entrada inválido.");
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }
}
