<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Notas/Faltas</title>
    <link rel="stylesheet" href=css/styleAluno.css?v=0.07">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>


<body>
    <div id="nav-bar">
        <input id="nav-toggle" type="checkbox">
        <div id="nav-header"><a id="nav-title" href="" target="_blank">Instituto Ensino</a>
            <div class="separator"></div>


            <hr/>

            <label for="nav-toggle"><span id="nav-toggle-burger"></span></label>

        </div>
        <div id="nav-content">
            <div class="nav-item"><span class="title">Acadêmico</span></div>
            <div class="nav-item"><span>${param.curso-nome}</span></div>

            <div class="separator"></div>

            <div class="nav-button"><i class="bx bx-log-out"></i><span>Logout</span></div>
        </div>

    </div>

    <div class="textoBoasVindas">
        <h1><span class="hand"><img src="../images/hand.png" alt="icone"></span> Bem-vindo à área do aluno!</h1>
    </div>


    <div class="gestao">
        <span class="icon"><i class="bx bx-edit-alt"></i></span>
        <h2>QUADRO DE AVISOS</h2>
    </div>

    <div class="separator1"></div>


    <div class="image-logo">
        <a href="home.jsp">
        <img src="images/logo.png" alt="Logo">
        </a>
    </div>

    <div class="table-container">

        <textarea class="quadro-avisos" placeholder="Você receberá seus avisos por aqui..." readonly></textarea>


        <h2 class="h2_1escrita">

            <i class="bx bx-info-circle icon1"></i>Informações
        </h2>

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
                    <tr>
                        <td class="materia">Básico</td>
                        <td class="faltas">0</td>
                        <td class="nota-final">10</td>

                    </tr>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>