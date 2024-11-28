package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.ProfessorDao;
import br.com.institutoensino.dao.UsuarioDao;
import br.com.institutoensino.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.sql.Date;

@WebServlet("/professor")
public class ProfessorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idUsuarioStr = request.getParameter("idUsuario");
        Date dataAtual = new Date(System.currentTimeMillis());
        request.setAttribute("dataAtual", dataAtual);
        
        if (idUsuarioStr != null && !idUsuarioStr.isEmpty()) {
            try {
                int idUsuario = Integer.parseInt(idUsuarioStr);

                UsuarioDao usuarioDao = new UsuarioDao();
                Usuario usuario = usuarioDao.findUserById(idUsuario);
                ProfessorDao professorDao = new ProfessorDao();
                int idProfessor = professorDao.getIdProfessorByIdUsuario(idUsuario);

                List<Map<String, Object>> materias = professorDao.getMateriasByIdProfessor(idProfessor);
                request.setAttribute("materias", materias);
                request.setAttribute("usuario", usuario);
                request.setAttribute("idProfessor", idProfessor);

                request.getRequestDispatcher("/professor.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato de ID inválido.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID do usuário não fornecido.");
        }
    }
}
