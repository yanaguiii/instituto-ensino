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
    <div id="nav-bar">
        <input id="nav-toggle" type="checkbox">
        <div id="nav-header"><a id="nav-title">Instituto Ensino</a>
            <div class="separator"></div>


            <hr/>

            <label for="nav-toggle"><span id="nav-toggle-burger"></span></label>

        </div>
        <div id="nav-content">
            <div class="nav-item"><span class="title">Acadêmico</span></div>
            <div class="nav-item"><span>${curso.nomeCurso}</span></div>

            <div class="separator"></div>

            <a href="logout">
                <div class="nav-button"><i class="bx bx-log-out"></i><span>Logout</span></div>
            </a>

        </div>

    </div>

    <div class="textoBoasVindas">
        <h1><span class="hand"><img src="../images/hand.png" alt="icone"></span> Bem-vindo à área do aluno, ${usuario.nomeUsuario}!</h1>
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
            <h2 class="h2_1escrita"><i class='bx bx-message-square-detail'></i>Avisos</h2>
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
</body>
</html>