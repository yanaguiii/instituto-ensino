package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.*;
import br.com.institutoensino.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;

@WebServlet("/aluno")
public class AlunoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idUsuarioStr = request.getParameter("idUsuario");

        if (idUsuarioStr != null && !idUsuarioStr.isEmpty()) {
            try {
                int idUsuario = Integer.parseInt(idUsuarioStr);

                UsuarioDao usuarioDao = new UsuarioDao();
                Usuario usuario = usuarioDao.findUserById(idUsuario);

                if (usuario != null) {
                    AlunoDao alunoDao = new AlunoDao();
                    int idAluno = alunoDao.getIdAlunoByIdUsuario(idUsuario);
                    Aluno aluno = alunoDao.findAlunoById(idAluno);

                    CursoDao cursoDao = new CursoDao();
                    Curso curso = cursoDao.getCursoById(aluno.getAlunoIdCurso());

                    List<Map<String, Object>> materiaInfos = alunoDao.buscarMateriasDoAluno(idUsuario);
                    request.setAttribute("materiaInfos", materiaInfos);

                    List<Integer> idMaterias = new ArrayList<>();
                    for (Map<String, Object> materiaInfo : materiaInfos) {
                        idMaterias.add((Integer) materiaInfo.get("idMateria"));
                    }

                    PostProfessorDao postProfessorDao = new PostProfessorDao();
                    List<PostProfessor> posts = postProfessorDao.buscarPostsPorMaterias(idMaterias);

                    request.setAttribute("usuario", usuario);
                    request.setAttribute("curso", curso);
                    request.setAttribute("posts", posts);

                    request.getRequestDispatcher("aluno.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Usuário não encontrado.");
                }
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato de ID inválido.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID do usuário não fornecido.");
        }
    }
}