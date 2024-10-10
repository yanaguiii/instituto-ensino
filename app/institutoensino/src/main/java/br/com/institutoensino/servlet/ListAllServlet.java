package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.*;
import br.com.institutoensino.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all")
public class ListAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        CursoDao cursoDao = new CursoDao();
        List<Curso> cursos = cursoDao.findAllCursos();
        req.setAttribute("cursos", cursos);


        UsuarioDao usuarioDao = new UsuarioDao();
        List<Usuario> usuarios = usuarioDao.findAllUsuarios();
        req.setAttribute("usuarios", usuarios);


        AlunoDao alunoDao = new AlunoDao();
        List<Aluno> alunos = alunoDao.findAllAlunos();
        req.setAttribute("alunos", alunos);


        ProfessorDao professorDao = new ProfessorDao();
        List<Professor> professores = professorDao.findAllProfessores();
        req.setAttribute("professores", professores);


        MateriaDao materiaDao = new MateriaDao();
        List<Materia> materias = materiaDao.findAllMaterias();
        req.setAttribute("materias", materias);


        AlunoMateriaDao alunoMateriaDao = new AlunoMateriaDao();
        List<AlunoMateria> alunoMaterias = alunoMateriaDao.findAllAlunoMaterias();
        req.setAttribute("alunoMaterias", alunoMaterias);


        PostProfessorDao postProfessorDao = new PostProfessorDao();
        List<PostProfessor> postProfessores = postProfessorDao.findAllPostProfessores();
        req.setAttribute("postProfessores", postProfessores);


        req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
}
