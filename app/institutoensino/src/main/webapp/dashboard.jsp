<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="css/dashboard.css?v=1.1">


</head>
<body>

<div class="container">

    <h1>Usuários</h1>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>ID Usuário</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Data de Nascimento</th>
            <th>CPF</th>
            <th>RG</th>
            <th>Logradouro</th>
            <th>Número</th>
            <th>Complemento</th>
            <th>Bairro</th>
            <th>Cidade</th>
            <th>Estado</th>
            <th>Celular</th>
            <th>Telefone Comercial</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="usuario" items="${usuarios}">
            <tr>
                <td>${usuario.idUsuario}</td>
                <td>${usuario.nomeUsuario}</td>
                <td>${usuario.email}</td>
                <td>${usuario.nascimento}</td>
                <td>${usuario.cpf}</td>
                <td>${usuario.rg}</td>
                <td>${usuario.logradouro}</td>
                <td>${usuario.numero}</td>
                <td>${usuario.complemento}</td>
                <td>${usuario.bairro}</td>
                <td>${usuario.cidade}</td>
                <td>${usuario.estado}</td>
                <td>${usuario.celular}</td>
                <td>${usuario.telefoneComercial}</td>
                <td>
                    <div class="action-buttons">

                        <a class="update" href="index.jsp?idUsuario=${usuario.idUsuario}&nomeUsuario=${usuario.nomeUsuario}&email=${usuario.email}&senha=${usuario.senha}&nascimento=${usuario.nascimento}&cpf=${usuario.cpf}&rg=${usuario.rg}&logradouro=${usuario.logradouro}&numero=${usuario.numero}&complemento=${usuario.complemento}&bairro=${usuario.bairro}&cidade=${usuario.cidade}&estado=${usuario.estado}&telefoneComercial=${usuario.telefoneComercial}&celular=${usuario.celular}">Update</a>

                        <form action="/delete-usuario" method="post">
                        <input type="hidden" id="idUsuario" name="idUsuario" value="${usuario.idUsuario}">
                        <button type="submit">Delete</button>
                    </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <h1>Cursos</h1>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>ID Curso</th>
            <th>Nome</th>
            <th>Modalidade</th>
            <th>Duração</th>
            <th>Campus</th>
            <th>Turno</th>
            <th>Descrição</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="curso" items="${cursos}">
            <tr>
                <td>${curso.idCurso}</td>
                <td>${curso.nomeCurso}</td>
                <td>${curso.modalidade}</td>
                <td>${curso.duracao}</td>
                <td>${curso.campus}</td>
                <td>${curso.turno}</td>
                <td>${curso.descricao}</td>
                <td>
                    <div class="action-buttons">

                        <a class="update" href="index.jsp?idCurso=${curso.idCurso}&nomeCurso=${curso.nomeCurso}&modalidade=${curso.modalidade}&duracao=${curso.duracao}&campus=${curso.campus}&turno=${curso.turno}&descricao=${curso.descricao}">Update</a>

                        <form action="/delete-curso" method="post">
                        <input type="hidden" name="idCurso" value="${curso.idCurso}">
                        <button type="submit">Delete</button>
                    </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>


    </table>


    <h1>Professores</h1>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>ID Professor</th>
            <th>Salário</th>
            <th>ID Usuário associado</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="professor" items="${professores}">
            <tr>
                <td>${professor.idProfessor}</td>
                <td>${professor.salario}</td>
                <td>${professor.professorIdUsuario}</td>
                <td>
                    <div class="action-buttons">

                        <a class="update" href="index.jsp?idProfessor=${professor.idProfessor}&salario=${professor.salario}&professorIdUsuario=${professor.professorIdUsuario}">Update</a>

                        <form action="/delete-professor" method="post">
                        <input type="hidden" id="idProfessor" name="idProfessor" value="${professor.idProfessor}">
                        <button type="submit">Delete</button>
                    </form>
                    </div>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h1>Alunos</h1>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>ID Aluno</th>
            <th>ID Usuário associado</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="aluno" items="${alunos}">
            <tr>
                <td>${aluno.idAluno}</td>
                <td>${aluno.alunoIdUsuario}</td>
                <td>
                    <div class="action-buttons">

                        <a class="update" href="index.jsp?idAluno=${aluno.idAluno}&alunoIdUsuario=${aluno.alunoIdUsuario}">Update</a>

                        <form action="/delete-aluno" method="post">
                        <input type="hidden" id="idAluno" name="idAluno" value="${aluno.idAluno}">
                        <button type="submit">Delete</button>

                    </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h1>Matérias</h1>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>ID Matéria</th>
            <th>Nome</th>
            <th>ID Curso associado</th>
            <th>ID Professor associado</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="materia" items="${materias}">
            <tr>
                <td>${materia.idMateria}</td>
                <td>${materia.nomeMateria}</td>
                <td>${materia.materiaIdCurso}</td>
                <td>${materia.materiaIdProfessor}</td>
                <td>
                    <div class="action-buttons">

                        <a class="update" href="index.jsp?idMateria=${materia.idMateria}&nomeMateria=${materia.nomeMateria}&materiaIdCurso=${materia.materiaIdCurso}&materiaIdProfessor=${materia.materiaIdProfessor}">Update</a>

                        <form action="/delete-materia" method="post">
                        <input type="hidden" id="idMateria" name="idMateria" value="${materia.idMateria}">
                        <button type="submit">Delete</button>
                    </form>
                    </div>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h1>Notas faltas</h1>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>ID Aluno associado</th>
            <th>ID Materia associada</th>
            <th>Nota</th>
            <th>Faltas</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="alunoMateria" items="${alunoMaterias}">
            <tr>
                <td>${alunoMateria.alunoMateriaIdAluno}</td>
                <td>${alunoMateria.alunoMateriaIdMateria}</td>
                <td>${alunoMateria.nota}</td>
                <td>${alunoMateria.faltas}</td>
                <td>
                    <div class="action-buttons">

                        <a class="update" href="index.jsp?alunoMateriaIdAluno=${alunoMateria.alunoMateriaIdAluno}&alunoMateriaIdMateria=${alunoMateria.alunoMateriaIdMateria}&nota=${alunoMateria.nota}&faltas=${alunoMateria.faltas}">Update</a>

                        <form action="/delete-aluno-materia" method="post">
                        <input type="hidden" id="idAlunoMateria" name="idAlunoMateria" value="${alunoMateria.alunoMateriaIdAluno}">
                        <input type="hidden" id="idMateriaAluno" name="idMateriaAluno" value="${alunoMateria.alunoMateriaIdMateria}">
                        <button type="submit">Delete</button>
                    </form>
                    </div>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h1>Posts Professor</h1>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>ID Post</th>
            <th>Conteúdo</th>
            <th>Data</th>
            <th>ID Professor associado</th>
            <th>ID Materia associada</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="postProfessor" items="${postProfessores}">
            <tr>
                <td>${postProfessor.idPost}</td>
                <td>${postProfessor.conteudo}</td>
                <td>${postProfessor.postData}</td>
                <td>${postProfessor.postIdProfessor}</td>
                <td>${postProfessor.postIdMateria}</td>
                <td>
                    <div class="action-buttons">

                        <a class="update" href="index.jsp?idPost=${postProfessor.idPost}&conteudo=${postProfessor.conteudo}&postData=${postProfessor.postData}&postIdProfessor=${postProfessor.postIdProfessor}&postIdMateria=${postProfessor.postIdMateria}">Update</a>

                        <form action="/delete-post-professor" method="post">
                        <input type="hidden" id="idPost" name="idPost" value="${postProfessor.idPost}">
                        <button type="submit">Delete</button>
                    </form>
                    </div>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="controle">
    <a class="menu" href="index.jsp">Adicionar elemento</a>
    <a class="menu" href="home.jsp">Home</a>
        <a class="menu" href="login.jsp">Login</a>
    </div>

</div>
</body>
</html>