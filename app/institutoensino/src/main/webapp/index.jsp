<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Formulários de Cadastro</title>
    <link crossorigin="anonymous" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" rel="stylesheet">
</head>

<body class="container">
<h1>Criar Usuário</h1>
<form action="/create-usuario" method="post">
    <div class="row">
        <div class="col-md-4 mb-3">
            <label class="form-label" for="usuario-nome">Nome:</label>
            <input class="form-control" id="usuario-nome" name="usuario-nome" placeholder="user" required type="text" value="${param.usuario.usuario-nome}">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="usuario-email">Email:</label>
            <input class="form-control" id="usuario-email" name="usuario-email" required type="email" value="${param.usuario-email}">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="usuario-senha">Senha:</label>
            <input class="form-control" id="usuario-senha" name="usuario-senha" required type="password" value="${param.usuario-senha}">
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 mb-3">
            <label class="form-label" for="usuario-nascimento">Data de Nascimento:</label>
            <input class="form-control" id="usuario-nascimento" name="usuario-nascimento" required type="date">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="usuario-cpf">CPF:</label>
            <input class="form-control" id="usuario-cpf" name="usuario-cpf" required type="text" value="${param.usuario-cpf}">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="usuario-rg">RG:</label>
            <input class="form-control" id="usuario-rg" name="usuario-rg" required type="text" value="${param.usuario-rg}">
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 mb-3">
            <label class="form-label" for="usuario-logradouro">Logradouro:</label>
            <input class="form-control" id="usuario-logradouro" name="usuario-logradouro" required type="text" value="${param.usuario-logradouro}">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="usuario-numero">Número:</label>
            <input class="form-control" id="usuario-numero" name="usuario-numero" required type="number" value="${param.usuario-numero}">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="usuario-complemento">Complemento:</label>
            <input class="form-control" id="usuario-complemento" name="usuario-complemento" type="text" value="${param.usuario-complemento}">
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 mb-3">
            <label class="form-label" for="usuario-bairro">Bairro:</label>
            <input class="form-control" id="usuario-bairro" name="usuario-bairro" required type="text" value="${param.usuario-bairro}">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="usuario-cidade">Cidade:</label>
            <input class="form-control" id="usuario-cidade" name="usuario-cidade" required type="text" value="${param.usuario-cidade}">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="usuario-estado">Estado:</label>
            <input class="form-control" id="usuario-estado" maxlength="2" name="usuario-estado" required type="text" value="${param.usuario-estado}">
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 mb-3">
            <label class="form-label" for="usuario-telefone-comercial">Telefone Comercial:</label>
            <input class="form-control" id="usuario-telefone-comercial" name="usuario-telefone-comercial" type="text" value="${param.usuario-telefone-comercial}">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="usuario-celular">Celular:</label>
            <input class="form-control" id="usuario-celular" name="usuario-celular" required type="text" value="${param.usuario-celular}">
            </div>

        <input type="hidden" id="idUsuario" name="idUsuario" value="${param.idUsuario}">
    </div>

    <button class="btn btn-primary" type="submit">Enviar</button>
</form>

<h1>Criar Curso</h1>
<form action="${pageContext.request.contextPath}/create-curso" method="post">
    <div class="row">
        <div class="col-md-4 mb-3">
            <label class="form-label" for="curso-nome">Nome do Curso:</label>
            <input class="form-control" id="curso-nome" name="curso-nome" required type="text">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="curso-modalidade">Modalidade:</label>
            <input class="form-control" id="curso-modalidade" name="curso-modalidade" required type="text">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="curso-duracao">Duração:</label>
            <input class="form-control" id="curso-duracao" name="curso-duracao" required step="0.1" type="number">
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 mb-3">
            <label class="form-label" for="curso-campus">Campus:</label>
            <input class="form-control" id="curso-campus" name="curso-campus" required type="text">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="curso-turno">Turno:</label>
            <input class="form-control" id="curso-turno" name="curso-turno" required type="text">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="curso-descricao">Descrição:</label>
            <input class="form-control" id="curso-descricao" name="curso-descricao" required type="text" >
        </div>

        <input type="hidden" id="idCurso" name="idCurso" value="${param.idCurso}">
    </div>

    <button class="btn btn-primary" type="submit">Enviar</button>
</form>

<h1>Criar Professor</h1>
<form action="/create-professor" method="post">

    <div class="row">
        <div class="col-md-4 mb-3">
            <label class="form-label" for="professor-id-usuario">ID do Usuário:</label>
            <input class="form-control" id="professor-id-usuario" name="professor-id-usuario" required type="number">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="professor-salario">Salário:</label>
            <input class="form-control" id="professor-salario" name="professor-salario" required step="0.01"
                   type="number">
        </div>

        <input type="hidden" id="idProfessor" name="idProfessor" value="${param.idProfessor}">
    </div>

    <button class="btn btn-primary" type="submit">Enviar</button>
</form>

<h1>Criar Aluno</h1>
<form action="/create-aluno" method="post">

    <div class="row">
        <div class="col-md-4 mb-3">
            <label class="form-label" for="aluno-id-usuario">ID do Usuário:</label>
            <input class="form-control" id="aluno-id-usuario" name="aluno-id-usuario" required type="number">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="aluno-matricula">Matrícula:</label>
            <input class="form-control" id="aluno-matricula" name="aluno-matricula" required type="text">
        </div>

        <input type="hidden" id="idAluno" name="idAluno" value="${param.idAluno}">
    </div>

    <button class="btn btn-primary" type="submit">Enviar</button>
</form>

<h1>Criar Matéria</h1>
<form action="/create-materia" method="post">
    <div class="row">
        <div class="col-md-4 mb-3">
            <label class="form-label" for="materia-nome">Nome da Matéria:</label>
            <input class="form-control" id="materia-nome" name="materia-nome" required type="text">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="materia-id-curso">ID do Curso:</label>
            <input class="form-control" id="materia-id-curso" name="materia-id-curso" required type="number">
        </div>

        <div class="col-md-4 mb-3">
            <label class="form-label" for="materia-id-professor">ID do Professor:</label>
            <input class="form-control" id="materia-id-professor" name="materia-id-professor" required type="number">
        </div>

        <input type="hidden" id="idMateria" name="idMateria" value="${param.idMateria}">
    </div>
    <button class="btn btn-primary" type="submit">Enviar</button>
</form>

<h1>Criar Aluno-Matéria</h1>
<form action="/create-aluno-materia" method="post">

    <div class="row">
        <div class="col-md-3 mb-3">
            <label class="form-label" for="aluno-materia-id-aluno">ID do Aluno:</label>
            <input class="form-control" id="aluno-materia-id-aluno" name="aluno-materia-id-aluno" required
                   type="number">
        </div>

        <div class="col-md-3 mb-3">
            <label class="form-label" for="aluno-materia-id-materia">ID da Matéria:</label>
            <input class="form-control" id="aluno-materia-id-materia" name="aluno-materia-id-materia" required
                   type="number">
        </div>

        <div class="col-md-3 mb-3">
            <label class="form-label" for="aluno-materia-nota">Nota:</label>
            <input class="form-control" id="aluno-materia-nota" name="aluno-materia-nota" required step="0.01"
                   type="number">
        </div>

        <div class="col-md-3 mb-3">
            <label class="form-label" for="aluno-materia-faltas">Faltas:</label>
            <input class="form-control" id="aluno-materia-faltas" name="aluno-materia-faltas" required type="number">
        </div>

        <input type="hidden" id="idAlunoMateria" name="idAlunoMateria" value="${param.idAlunoMateria}">
    </div>

    <button class="btn btn-primary" type="submit">Enviar</button>
</form>

<h1>Criar Post de Professor</h1>
<form action="/create-post-professor" method="post">

    <div class="row">
        <div class="col-md-3 mb-3">
            <label class="form-label" for="post-conteudo">Conteúdo do Post:</label>
            <textarea class="form-control" id="post-conteudo" name="post-conteudo" required></textarea>
        </div>

        <div class="col-md-3 mb-3">
            <label class="form-label" for="post-data">Data:</label>
            <input class="form-control" id="post-data" name="post-data" required type="date">
        </div>

        <div class="col-md-3 mb-3">
            <label class="form-label" for="post-id-professor">ID do Professor:</label>
            <input class="form-control" id="post-id-professor" name="post-id-professor" required type="number">
        </div>

        <div class="col-md-3 mb-3">
            <label class="form-label" for="post-id-materia">ID da Matéria:</label>
            <input class="form-control" id="post-id-materia" name="post-id-materia" required type="number">
        </div>

        <input type="hidden" id="idPostProfessor" name="idPostProfessor" value="${param.idPostProfessor}">
    </div>

    <button class="btn btn-primary" type="submit">Enviar</button>
</form>

<form action="find-all" method="get">
    <button class="btn btn-primary" type="submit">Carregar Todas as Tabelas</button>
</form>

<script crossorigin="anonymous"
        integrity="sha384-rp+3U+I8dFO29EtG2vFI0g9MHLh4sPLQJ7bBn3fLphfh5dfufJrdl4zrcAM7G8kC"
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
