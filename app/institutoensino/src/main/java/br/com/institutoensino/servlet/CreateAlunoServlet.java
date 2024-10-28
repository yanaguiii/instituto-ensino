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
        String matricula = req.getParameter("aluno-matricula");

        try {
            int idUsuario = Integer.parseInt(idUsuarioStr);
            AlunoDao alunoDao = new AlunoDao();
            Aluno aluno;

            if (idAlunoStr == null || idAlunoStr.isBlank()) {
                // Criação de um novo aluno se o idAluno não estiver presente ou estiver em branco
                aluno = new Aluno(idUsuario, matricula);
                alunoDao.createAluno(aluno);
            } else {
                // Atualização do aluno existente se o idAluno estiver presente
                int idAluno = Integer.parseInt(idAlunoStr);
                aluno = new Aluno(idAluno, idUsuario, matricula); // Inclui o ID do aluno para atualização
                alunoDao.updateAluno(aluno);
            }

            resp.sendRedirect("/find-all");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Formato de entrada inválido.");
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }
}

