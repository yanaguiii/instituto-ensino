<%@ page import="br.com.institutoensino.model.Usuario" %>
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
    <link rel="stylesheet" href="css/styleProfessor.css?v=2.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
        <div class="nav-item"><span class="title">Suas Matérias</span></div>
        <c:forEach var="materia" items="${materias}">
            <div class="nav-item">
                <a href="#${materia.nomeMateria.replace(' ', '_')}"><span>${materia.nomeMateria}</span></a>
            </div>
        </c:forEach>
        <div class="separator"></div>

        <a href="logout.jsp">
            <div class="nav-button"><i class="bx bx-log-out"></i><span>Logout</span></div>
        </a>
    </div>
</div>

<div class="textoBoasVindas">
    <h1><span class="hand"><img src="images/hand.png" alt="icone"></span> Bem-vindo à área do professor, <%= usuario.getNomeUsuario() %>!</h1>
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

<div class="content-wrapper">
    <div class="table-container">
        <c:forEach var="materia" items="${materias}">
            <h2 class="h2_1escrita" id="${materia.nomeMateria.replace(' ', '_')}">
                <i class="bx bx-book icon1"></i>${materia.nomeMateria}
            </h2>
            <div class="fundo">
                <table>
                    <thead>
                    <tr>
                        <th>Aluno</th>
                        <th>Faltas</th>
                        <th>Nota Final</th>
                        <th>Ações</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="aluno" items="${materia.alunos}">
                        <tr>
                            <td class="aluno">${aluno.nomeAluno}</td>
                            <td class="faltas">
                                <span class="text-faltas">${aluno.faltas}</span>
                                <input type="number" name="faltas" value="${aluno.faltas}" class="input-faltas hidden" min="0">
                            </td>
                            <td class="nota-final">
                                <span class="text-nota">${aluno.nota}</span>
                                <input type="number" step="0.01" name="nota" value="${aluno.nota}" class="input-nota hidden" min="0" max="10">
                            </td>
                            <td>
                                <button type="button" class="btn-modificar">Modificar</button>
                                <button type="button" class="btn-salvar hidden">Salvar</button>
                                <input type="hidden" name="aluno-materia-id-aluno" value="${aluno.idAluno}">
                                <input type="hidden" name="aluno-materia-id-materia" value="${materia.idMateria}">
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:forEach>
    </div>

    <div class="post-form-container">
        <h2 class="h2_1escrita"><i class="bx bx-message-square-add icon1"></i>Criar Novo Post</h2>
        <form action="postar-post-professor" method="post">
            <textarea name="post-conteudo" placeholder="Escreva seu post aqui..." required></textarea>
            <input type="hidden" name="post-data" value="<%= new java.sql.Date(System.currentTimeMillis()) %>">
            <input type="hidden" name="post-id-professor" value="<%= idProfessor %>">
            <select name="post-id-materia" required>
                <option value="">Selecione a matéria</option>
                <c:forEach var="materia" items="${materias}">
                    <option value="${materia.idMateria}">${materia.nomeMateria}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn-criar-post">Criar Post</button>
        </form>
    </div>
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

<script src="js/scriptProfessor.js?v=1.2"></script>

</body>
</html>