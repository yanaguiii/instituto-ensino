package br.com.institutoensino.servlet;

import br.com.institutoensino.dao.MateriaDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-materia")
public class DeleteMateriaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idMateria = Integer.parseInt(req.getParameter("idMateria"));

        new MateriaDao().deleteMateriaById(idMateria);

        resp.sendRedirect("/find-all");
    }
}
