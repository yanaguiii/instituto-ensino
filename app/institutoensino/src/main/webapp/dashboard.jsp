<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>

<div class="container-fluid">
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
                <td>${curso.nome}</td>
                <td>${curso.modalidade}</td>
                <td>${curso.duracao}</td>
                <td>${curso.campus}</td>
                <td>${curso.turno}</td>
                <td>${curso.descricao}</td>
                <td>
                    <!-- Formulário de exclusão -->
                    <form action="/delete-curso" method="post">
                        <input type="hidden" name="idCurso" value="${curso.idCurso}">
                        <button type="submit">Delete</button>

                        <span> | </span>

                        <a href="index.jsp?idCurso=${curso.idCurso}&curso-nome=${curso.nome}&curso-modalidade=${curso.modalidade}&curso-duracao=${curso.duracao}&curso-campus=${curso.campus}&curso-turno=${curso.turno}&curso-descricao=${curso.descricao}">Update Curso</a>
                    </form>

                </td>
            </tr>
        </c:forEach>
        </tbody>


    </table>

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
                <td>${usuario.nome}</td>
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
                    <form action="/delete-usuario" method="post">
                        <input type="hidden" id="idUsuario" name="idUsuario" value="${usuario.idUsuario}">
                        <button type="submit">Delete</button>

                    <span>|</span>

                        <a href="index.jsp?idUsuario=${usuario.idUsuario}&usuario-nome=${usuario.nome}&usuario-email=${usuario.email}&usuario-senha=${usuario.senha}&usuario-nascimento=${usuario.nascimento}&usuario-cpf=${usuario.cpf}&usuario-rg=${usuario.rg}&usuario-logradouro=${usuario.logradouro}&usuario-numero=${usuario.numero}&usuario-complemento=${usuario.complemento}&usuario-bairro=${usuario.bairro}&usuario-cidade=${usuario.cidade}&usuario-estado=${usuario.estado}&usuario-telefone-comercial=${usuario.telefoneComercial}&usuario-celular=${usuario.celular}">Update User</a>

                    </form>
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
        </tr>
        </thead>
        <tbody>
        <c:forEach var="professor" items="${professores}">
            <tr>
                <td>${professor.idProfessor}</td>
                <td>${professor.salario}</td>
                <td>
                    <form action="/delete-professor" method="post">
                        <input type="hidden" id="idProfessor" name="idProfessor" value="${professor.idProfessor}">
                        <button type="submit">Delete</button>
                    </form>
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
            <th>Matricula</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="aluno" items="${alunos}">
            <tr>
                <td>${aluno.idAluno}</td>
                <td>${aluno.matricula}</td>
                <td>
                    <form action="/delete-aluno" method="post">
                        <input type="hidden" id="idAluno" name="idAluno" value="${aluno.idAluno}">
                        <button type="submit">Delete</button>

                        <span> | </span>

                        <a href="index.jsp?idAluno=${aluno.idAluno}&aluno-matricula=${aluno.matricula}">Update Aluno</a>
                    </form>

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
            <th>ID Curso</th>
            <th>ID Professor</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="materia" items="${materias}">
            <tr>
                <td>${materia.idMateria}</td>
                <td>${materia.nome}</td>
                <td>${materia.idCurso}</td>
                <td>${materia.idProfessor}</td>
                <td>
                    <form action="/delete-materia" method="post">
                        <input type="hidden" id="idMateria" name="idMateria" value="${materia.idMateria}">
                        <button type="submit">Delete</button>
                    </form>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h1>Notas faltas (AlunoMateria)</h1>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>ID Aluno</th>
            <th>ID Materia</th>
            <th>Nota</th>
            <th>Faltas</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="alunoMateria" items="${alunoMaterias}">
            <tr>
                <td>${alunoMateria.idAluno}</td>
                <td>${alunoMateria.idMateria}</td>
                <td>${alunoMateria.nota}</td>
                <td>${alunoMateria.faltas}</td>
                <td>
                    <form action="/delete-aluno-materia" method="post">
                        <input type="hidden" id="idAlunoMateria" name="idAluno" value="${alunoMateria.idAluno}">
                        <input type="hidden" id="idMateriaAluno" name="idMateria" value="${alunoMateria.idMateria}">
                        <button type="submit">Delete</button>
                    </form>
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
            <th>ID Professor</th>
            <th>ID Materia</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="postProfessor" items="${postProfessores}">
            <tr>
                <td>postProfessor.idPost</td>
                <td>${postProfessor.conteudo}</td>
                <td>${postProfessor.data}</td>
                <td>${postProfessor.idProfessor}</td>
                <td>${postProfessor.idMateria}</td>
                <td>
                    <form action="/delete-post-professor" method="post">
                        <input type="hidden" id="idPost" name="idPost" value="${postProfessor.idPost}">
                        <button type="submit">Delete</button>
                    </form>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>