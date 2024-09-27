package br.com.institutoensino.servlet;

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

        String cursoName = req.getParameter("curso-name");

        System.out.println(cursoName);

        req.getRequestDispatcher("index.html").forward(req,resp);

    }
}
