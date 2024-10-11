<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela de login</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>

<div class="container">
    <div class="triangle"></div>

    <!-- Logo -->
    <div class="image-logo">
        <img src="images/logo.png" alt="Logo Instituto Ensino">
    </div>
</div>

<div class="login-container">
    <h1>Bem vindo ao Instituto Ensino! </h1>
    <h2>Faça login agora</h2>


    <form action="/login" method="POST">
        <label for="email">Seu Email</label>
        <input type="email" name="email" id="email" placeholder="Digite seu email" required>

        <label for="password">Sua Senha</label>
        <div class="password-container">
            <input type="password" name="password" id="password" placeholder="Digite sua senha" required>
            <i id="togglePassword" class="fa fa-eye"></i>
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
            // Limpa a mensagem após a exibição
            request.removeAttribute("mensagemErro");
        }
    %>

    <p>Ainda não tem conta? <a href="#">Cadastre-se</a></p>
</div>

<script src="js/script.js"></script>

</body>
</html>
