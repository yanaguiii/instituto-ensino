package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.CursoDao;
import br.com.institutoensino.model.Curso;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-curso")
public class CreateCursoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cursoNome = req.getParameter("curso-nome");
        String cursoModalidade = req.getParameter("curso-modalidade");
        String cursoDuracaoStr = req.getParameter("curso-duracao");
        String cursoCampus = req.getParameter("curso-campus");
        String cursoTurno = req.getParameter("curso-turno");
        String cursoDescricao = req.getParameter("curso-descricao");

        Float cursoDuracao = null;

        try {
            cursoDuracao = Float.parseFloat(cursoDuracaoStr);

            Curso curso = new Curso(cursoNome, cursoModalidade, cursoDuracao, cursoCampus, cursoTurno, cursoDescricao);

            new CursoDao().createCurso(curso);

            resp.sendRedirect("/find-all-cursos");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Formato de duração inválido.");
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", "Erro ao criar curso: " + e.getMessage());
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }
}
