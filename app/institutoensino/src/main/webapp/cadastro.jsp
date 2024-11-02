<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <title>Tela de cadastro</title>
    <link rel="stylesheet" type="text/css" href="css/cadastro.css?v=4.0">
</head>

<body>

<div class="container">
    <div class="triangle"></div>
</div>

<div class="form-container">
    <h1>Cadastre-se</h1>

    <form action="/cadastro" method="post">
        <!-- Bloco de Dados Cadastrais -->
        <div class="block" id="login">
            <div class="block-title">
                <i class='bx bx-envelope icon'></i>
                Dados para login
            </div>

            <!-- Grupo de Email -->
            <div class="form-row" id="email-group">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="usuario-email" placeholder="Digite seu email" required
                           value="<%= request.getAttribute("usuarioEmail") != null ? request.getAttribute("usuarioEmail") : "" %>">
                    <div class="form-group-erro">
                           <span class="error-message" id="email-error"></span>
                    </div>
                </div>

                <div class="form-group" id="confirm-email-group">
                    <label for="confirm-email">Confirme seu email</label>
                    <input type="email" id="confirm-email" name="confirm-email" placeholder="Confirme seu email"
                           required value="<%= request.getAttribute("usuarioEmail") != null ? request.getAttribute("usuarioEmail") : "" %>">
                </div>
            </div>

            <!-- Grupo de Senha -->
            <div class="form-row" id="password-group">
                <div class="form-group">
                    <label for="password">Senha</label>
                    <input type="password" id="password" name="usuario-senha" placeholder="Digite sua senha" required>
                    <div class="form-group-erro">
                        <span class="error-message" id="password-error"></span>
                    </div>
                </div>


                <div class="form-group" id="confirm-password-group">
                    <label for="confirm-password">Confirme sua senha</label>
                    <input type="password" id="confirm-password" name="confirm-password"
                           placeholder="Confirme sua senha" required>
                </div>
            </div>
        </div>

        <div class="separator"></div>

        <div class="block">

            <div class="block-title">
                <i class='bx bx-user icon'></i>
                Dados Pessoais
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label>Nome Completo</label>
                    <input type="text" name="usuario-nome" placeholder="Digite seu nome completo" required
                           value="<%= request.getAttribute("usuarioNome") != null ? request.getAttribute("usuarioNome") : "" %>">
                </div>

                <div class="form-group">
                    <label>Data de Nascimento</label>
                    <input type="date" name="usuario-nascimento" placeholder="00/00/0000" required
                           value="<%= request.getAttribute("usuarioNascimento") != null ? request.getAttribute("usuarioNascimento") : "" %>">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label>RG</label>
                    <input type="text" id="rg" name="usuario-rg" placeholder="00.000.000-0" oninput="formatRG(this)"
                           required maxlength="12"
                           value="<%= request.getAttribute("usuarioRg") != null ? request.getAttribute("usuarioRg") : "" %>">
                </div>
                <div class="form-group">
                    <label>CPF</label>
                    <input type="text" id="cpf" name="usuario-cpf" placeholder="000.000.000-00"
                           oninput="formatCPF(this)" required maxlength="14"
                           value="<%= request.getAttribute("usuarioCpf") != null ? request.getAttribute("usuarioCpf") : "" %>">
                </div>
            </div>

        </div>

        <div class="separator"></div>

        <div class="block">

            <div class="block-title">
                <i class='bx bx-home icon'></i>
                Dados Residenciais
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label>Logradouro</label>
                    <input type="text" name="usuario-logradouro" placeholder="Logradouro" required
                           value="<%= request.getAttribute("usuarioLogradouro") != null ? request.getAttribute("usuarioLogradouro") : "" %>">

                </div>
                <div class="form-group">
                    <label>Número</label>
                    <input type="text" name="usuario-numero" placeholder="Número" required
                           value="<%= request.getAttribute("usuarioNumero") != null ? request.getAttribute("usuarioNumero") : "" %>">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label>Complemento</label>
                    <input type="text" name="usuario-complemento" placeholder="Complemento (Opcional)"
                           value="<%= request.getAttribute("usuarioComplemento") != null ? request.getAttribute("usuarioComplemento") : "" %>">
                </div>
                <div class="form-group">
                    <label>Bairro</label>
                    <input type="text" name="usuario-bairro" placeholder="Bairro" required
                           value="<%= request.getAttribute("usuarioBairro") != null ? request.getAttribute("usuarioBairro") : "" %>">

                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label>Cidade</label>
                    <input type="text" name="usuario-cidade" placeholder="Cidade" required
                           value="<%= request.getAttribute("usuarioBairro") != null ? request.getAttribute("usuarioBairro") : "" %>">

                </div>

                <div class="form-group">
                    <label>Estado</label>
                    <input type="text" name="usuario-estado" placeholder="Estado" maxlength="2" required
                           value="<%= request.getAttribute("usuarioEstado") != null ? request.getAttribute("usuarioEstado") : "" %>">

                </div>
            </div>

        </div>

        <div class="separator"></div>

        <div class="block">
            <div class="block-title">
                <i class='bx bx-mobile-alt icon'></i>
                Contato
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label>Telefone Comercial</label>
                    <input type="text" name="usuario-telefone-comercial" placeholder="(00) 00000-0000 (Opcional)"
                           value="<%= request.getAttribute("usuarioTelefoneComercial") != null ? request.getAttribute("usuarioTelefoneComercial") : "" %>">
                </div>
                <div class="form-group">
                    <label>Celular</label>
                    <input type="text" name="usuario-celular" placeholder="(00) 00000-0000" required
                           value="<%= request.getAttribute("usuarioCelular") != null ? request.getAttribute("usuarioCelular") : "" %>">
                </div>
            </div>
        </div> <!-- Aqui fecha a div do bloco de Contato -->

        <div class="separator"></div>

        <button type="submit">Registrar-se</button>
    </form>
</div>

<div class="block">
    <div class="link">
        Já tem uma conta? <a href="${pageContext.request.contextPath}/login.jsp">Acesse já</a>
    </div>
</div>

<div class="image-logo">
    <img src="images/logo.png" alt="Logo Instituto Ensino">
</div>

<script src="js/scriptCadastro.js?v=3.7"></script>

</body>
</html>
