<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<h1>Cursos</h1>
<br>

<div class="container-fluid">
    <table class="table">
        <thead>
        <tr>
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
                <td>${curso.nome}</td>
                <td>${curso.modalidade}</td>
                <td>${curso.duracao}</td>
                <td>${curso.campus}</td>
                <td>${curso.turno}</td>
                <td>${curso.descricao}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h1>Usuários</h1>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>Nome</th>
            <th>Email</th>
            <th>Data de Nascimento</th>
            <th>CPF</th>
            <th>RG</th>
            <th>Logradouro</th>
            <th>Número</th>
            <th>Complemento</th>
            <th>Cidade</th>
            <th>Estado</th>
            <th>Celular</th>
            <th>Telefone Comercial</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="usuario" items="${usuarios}">
            <tr>
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
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h1>Alunos</h1>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Matricula</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="aluno" items="${alunos}">
            <tr>
                <td>${aluno.idAluno}</td>
                <td>${aluno.matricula}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h1>Matérias</h1>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>Nome</th>
            <th>ID Curso</th>
            <th>ID Professor</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="materia" items="${materias}">
            <tr>
                <td>${materia.nome}</td>
                <td>${materia.idCurso}</td>
                <td>${materia.idProfessor}</td>
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
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h1>Posts Professor</h1>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>Conteúdo</th>
            <th>Data</th>
            <th>ID Professor</th>
            <th>ID Materia</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="postProfessor" items="${postProfessores}">
            <tr>
                <td>${postProfessor.conteudo}</td>
                <td>${postProfessor.data}</td>
                <td>${postProfessor.idProfessor}</td>
                <td>${postProfessor.idMateria}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>