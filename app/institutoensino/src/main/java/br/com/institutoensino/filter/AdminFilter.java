package br.com.institutoensino.filter;

import br.com.institutoensino.model.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/admin.jsp", "/dashboard.jsp",
        "/delete-aluno-materia",
        "/delete-aluno",
        "/delete-curso",
        "/delete-materia",
        "/delete-post-professor",
        "/delete-professor",
        "/delete-usuario",

        "/find-all",
        "/find-all-aluno-materias",
        "/find-all-alunos",
        "/find-all-cursos",
        "/find-all-materias",
        "/find-all-post-professores",
        "/find-all-professores",
        "/find-all-usuarios",

        "/create-aluno-materia",
        "/create-aluno",
        "/create-curso",
        "/create-materia",
        "/create-post-professor",
        "/create-professor",
        "/create-usuario",

})
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("usuarioLogado") != null);

        if (isLoggedIn) {
            Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
            if (usuario.isAdmin()) {
                chain.doFilter(request, response); // Usuário é admin, permite o acesso
            } else {
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/home.jsp"); // Usuário não é admin, redireciona para home
            }
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp"); // Usuário não está logado, redireciona para login
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}