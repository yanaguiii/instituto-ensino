<%@ page import="br.com.institutoensino.model.Usuario" %>
<%@ page import="br.com.institutoensino.model.Professor" %>
<%@ page import="br.com.institutoensino.dao.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Área do Professor</title>
    <link rel="stylesheet" href="css/styleProfessor.css?v=0.2">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>

<body>
<%
    String idUsuarioStr = request.getParameter("idUsuario");
    if (idUsuarioStr != null && !idUsuarioStr.isEmpty()) {
        try {
            int idUsuario = Integer.parseInt(idUsuarioStr);

            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario usuario = usuarioDao.findUserById(idUsuario);
            ProfessorDao professorDao = new ProfessorDao();
            int idProfessor = professorDao.getIdProfessorByIdUsuario(idUsuario);

            List<Map<String, Object>> materias = professorDao.getMateriasByIdProfessor(idProfessor);
            request.setAttribute("materias", materias);

            if (usuario != null) {
%>

<div id="nav-bar">
    <input id="nav-toggle" type="checkbox">
    <div id="nav-header"><a id="nav-title" href="home.jsp">Instituto Ensino</a>
        <div class="separator"></div>
        <hr/>
        <label for="nav-toggle"><span id="nav-toggle-burger"></span></label>
    </div>
    <div id="nav-content">
        <div class="nav-item"><span class="title">Acadêmico</span></div>
        <c:forEach var="materia" items="${materias}">
            <div class="nav-item"><span>${materia.nomeMateria}</span></div>
        </c:forEach>
        <div class="separator"></div>

        <a href="logout.jsp">
            <div class="nav-button"><i class="bx bx-log-out"></i><span>Logout</span></div>
        </a>


    </div>
</div>

<div class="textoBoasVindas">
    <h1><span class="hand"><img src="../images/hand.png" alt="icone"></span> Bem-vindo à área do professor, <%= usuario.getNomeUsuario() %>!</h1>
</div>

<div class="gestao">
    <span class="icon"><i class="bx bx-edit-alt"></i></span>
    <h2>GESTÃO DE ALUNOS</h2>
</div>

<div class="separator1"></div>

<div class="image-logo">
    <a href="home.jsp">
        <img src="images/logo.png" alt="Logo">
    </a>
</div>

<div class="table-container">
    <c:forEach var="materia" items="${materias}">
        <h2 class="h2_1escrita"><i class="bx bx-book icon1"></i>${materia.nomeMateria}</h2>
        <div class="fundo">
            <table>
                <thead>
                <tr>
                    <th>Aluno</th>
                    <th>Faltas</th>
                    <th>Nota Final</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="aluno" items="${materia.alunos}">
                    <tr>
                        <td class="aluno">${aluno.nomeAluno}</td>
                        <td class="faltas">${aluno.faltas}</td>
                        <td class="nota-final">${aluno.nota}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:forEach>
</div>
<%
            } else {
                System.out.println("<h1>Usuário não encontrado.</h1>");
            }
        } catch (NumberFormatException e) {
                System.out.println("<h1>Formato de ID inválido.</h1>");
        }
    } else {
                System.out.println("<h1>ID do usuário não fornecido.</h1>");
    }
%>
</body>
</html>