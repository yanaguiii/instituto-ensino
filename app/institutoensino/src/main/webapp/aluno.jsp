<%@ page import="br.com.institutoensino.model.Usuario" %>
<%@ page import="br.com.institutoensino.model.Aluno" %>
<%@ page import="br.com.institutoensino.model.Curso" %>
<%@ page import="br.com.institutoensino.dao.*" %>
<%@ page import="br.com.institutoensino.model.AlunoMateria" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Área do Aluno</title>
    <link rel="stylesheet" href=css/styleAluno.css?v=0.08">
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
            AlunoDao alunoDao = new AlunoDao();
            int idAluno = alunoDao.getIdAlunoByIdUsuario(idUsuario);
            Aluno aluno = alunoDao.findAlunoById(idAluno);
            CursoDao cursoDao = new CursoDao();
            Curso curso = cursoDao.getCursoById(aluno.getAlunoIdCurso());

            List<Map<String, Object>> materiaInfos = alunoDao.buscarMateriasDoAluno(idUsuario);
            request.setAttribute("materiaInfos", materiaInfos);

            // Call the servlet to fetch professor posts

            if (usuario != null) {
%>

    <div id="nav-bar">
        <input id="nav-toggle" type="checkbox">
        <div id="nav-header"><a id="nav-title" href="" target="_blank">Instituto Ensino</a>
            <div class="separator"></div>


            <hr/>

            <label for="nav-toggle"><span id="nav-toggle-burger"></span></label>

        </div>
        <div id="nav-content">
            <div class="nav-item"><span class="title">Acadêmico</span></div>
            <div class="nav-item"><span><%= curso.getNomeCurso() %></span></div>

            <div class="separator"></div>

            <a href="logout.jsp">
                <div class="nav-button"><i class="bx bx-log-out"></i><span>Logout</span></div>
            </a>

        </div>

    </div>

    <div class="textoBoasVindas">
        <h1><span class="hand"><img src="../images/hand.png" alt="icone"></span> Bem-vindo à área do aluno, <%= usuario.getNomeUsuario() %>!</h1>
    </div>


    <div class="gestao">
        <span class="icon"><i class="bx bx-edit-alt"></i></span>
        <h2>QUADRO DO ALUNO</h2>
    </div>

    <div class="separator1"></div>


    <div class="image-logo">
        <a href="home.jsp">
        <img src="images/logo.png" alt="Logo">
        </a>
    </div>

    <div class="table-container">

        <div class="quadro-avisos">
            <c:forEach var="post" items="${posts}">
                <div class="post">
                    <p class="post-content">${post.conteudo}</p>
                    <p class="post-date">Data: ${post.postData}</p>
                </div>
            </c:forEach>
        </div>

        <h2 class="h2_1escrita"><i class="bx bx-info-circle icon1"></i>Notas/Faltas</h2>

        <div class="fundo">
            <table>
                <thead>
                <tr>
                    <th>Matéria</th>
                    <th>Faltas</th>
                    <th>Nota Final</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="materiaInfo" items="${materiaInfos}">
                    <tr>
                        <td class="materia">${materiaInfo.nomeMateria}</td>
                        <td class="faltas">${materiaInfo.faltas}</td>
                        <td class="nota-final">${materiaInfo.nota}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
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
</body>
</html>