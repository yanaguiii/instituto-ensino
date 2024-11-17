<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela de Login</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>

<div class="container">
    <div class="triangle"></div>

    <!-- Logo -->
    <div class="image-logo">
        <a href="home.jsp">
            <img src="images/logo.png" alt="Logo Instituto Ensino" style="border: none;">
        </a>
    </div>

</div>

<div class="login-container">
    <h1>Bem-vindo ao Instituto Ensino!</h1>
    <h2>Faça login agora</h2>

    <form action="/login" method="POST">
        <label for="email">Seu Email</label>
        <input type="email" name="email" id="email" placeholder="Digite seu email" required aria-label="Email">

        <label for="password">Sua Senha</label>
        <div class="password-container">
            <input type="password" name="password" id="password" placeholder="Digite sua senha" required
                   aria-label="Senha">
            <i id="togglePassword" class="fa fa-eye" aria-hidden="true" title="Mostrar/Ocultar Senha"></i>
        </div>

        <button type="submit">Acessar</button>
    </form>

    <%
        if (request.getAttribute("mensagemErro") != null) {
            String mensagemErro = (String) request.getAttribute("mensagemErro");
    %>
    <div class="error-message">
        <%= mensagemErro %>
    </div>
    <%
            request.removeAttribute("mensagemErro");
        }
    %>

    <p>Ainda não tem conta? <a href="${pageContext.request.contextPath}/home.jsp"><br>Escolha um curso e cadastre-se!</a></p>
</div>

<script src="js/scriptLogin.js"></script>

</body>
</html>
