package br.com.institutoensino.filter;

import br.com.institutoensino.model.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/professor")
public class ProfessorFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        String requestedIdUsuario = httpRequest.getParameter("idUsuario");

        if (session != null && session.getAttribute("usuarioLogado") != null) {
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

            if (requestedIdUsuario != null && requestedIdUsuario.equals(String.valueOf(usuarioLogado.getIdUsuario()))) {
                chain.doFilter(request, response);
            } else {
                httpResponse.sendRedirect("home.jsp");
            }
        } else {
            httpResponse.sendRedirect("login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}