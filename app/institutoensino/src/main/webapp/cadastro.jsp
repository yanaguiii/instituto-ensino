<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <title>Tela de cadastro</title>
    <link rel="stylesheet" type="text/css" href="css/cadastro.css">
</head>
<body>
    
    <div class="container">
        <div class="triangle"></div>
    </div>

    <div class="form-container">
        <h1>Cadastre-se</h1>

        <!-- Bloco de Dados Cadastrais -->
        <div class="block">
            <div class="block-title">
                <i class='bx bx-envelope icon'></i>
                Dados para login
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" placeholder="exemplo@exemplo.com">
                </div>
                <div class="form-group">
                    <label>Confirme seu email</label>
                    <input type="email" placeholder="exemplo@exemplo.com">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group">
                    <label>Senha</label>
                    <input type="password" placeholder="Digite sua senha">
                </div>
                <div class="form-group">
                    <label>Confirme sua senha</label>
                    <input type="password" placeholder="Confirme sua senha">
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
                    <input type="text" placeholder="Digite seu nome completo">
                </div>
                <div class="form-group">
                    <label>Nome social</label>
                    <input type="text" placeholder="Digite seu nome social (Opcional)">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label>RG</label>
                    <input type="text" placeholder="00.000.000-0">
                </div>
                <div class="form-group">
                    <label>CPF</label>
                    <input type="text" placeholder="000.000.000-00">
                </div>
            </div>
            
            <div class="form-row">
                <div class="form-group">
                    <label>Data de Nascimento</label>
                    <input type="text" placeholder="00/00/0000">
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
                    <input type="text" placeholder="Logradouro">
                </div>
                <div class="form-group">
                    <label>Número</label>
                    <input type="text" placeholder="Número">
                </div>
            </div>
            
            <div class="form-row">
                <div class="form-group">
                    <label>Complemento</label>
                    <input type="text" placeholder="Complemento">
                </div>
                <div class="form-group">
                    <label>Bairro</label>
                    <input type="text" placeholder="Bairro">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label>Estado</label>
                    <input type="text" placeholder="Estado">
                </div>

                <div class="form-group">
                    <label>Cidade</label>
                    <input type="text" placeholder="Cidade">
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
                    <input type="text" placeholder="(00) 00000-0000">
                </div>
                <div class="form-group">
                    <label>Celular</label>
                    <input type="text" placeholder="(00) 00000-0000">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label>Telefone residencial</label>
                    <input type="text" placeholder="(00) 0000-0000">
                </div>
            </div>
        </div>


        <div class="separator"></div>

        <button type="submit">Registrar-se</button>

        <div class="link">
            Já tem uma conta? <a href="${pageContext.request.contextPath}/login.jsp">Acesse já</a>
        </div>
        
    </div>


    <div class="image-logo">
        <img src="images/logo.png" alt="Logo Instituto Ensino">
    </div>

    <script src="js/scriptCadastro.js"></script>

</body>
</html>
