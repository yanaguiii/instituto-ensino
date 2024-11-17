<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>tela do aluno</title>
    <link rel="stylesheet" href="../css/styleAluno.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    




</head>

<body>
    <!-- partial:index.partial.html -->
    <div id="nav-bar">
        <input id="nav-toggle" type="checkbox" />
        <div id="nav-header"><a id="nav-title" href="" target="_blank">Instituto Ensino</a>
            <div class="separator"></div>


            <hr />

            <label for="nav-toggle"><span id="nav-toggle-burger"></span></label>

        </div>
        <div id="nav-content">
            <div class="nav-button"><span>Acadêmico</span></div>

            <div class="separator"></div>
            <div class="nav-button" onclick="carregarDadosMateria(1)"><i class="bx bx-book"></i><span>Direito</span></div>
            <div class="nav-button" onclick="carregarDadosMateria(2)"><i class="bx bx-bullseye"></i><span>Marketing Digital</span></div>
            <div class="nav-button" onclick="carregarDadosMateria(3)"><i class="bx bx-line-chart"></i><span>Excel</span></div>
            <div class="nav-button" onclick="carregarDadosMateria(4)"><i class="bx bx-dollar"></i><span>Economia</span></div>

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
        <img src="../images/logo.png" alt="Logo">
    </div>

    <div class="table-container">

        <textarea class="quadro-avisos" placeholder="Você recebera seus avisos por aqui..." readonly></textarea>


        <h2 class="h2_1escrita">

            <i class="bx bx-info-circle icon1"></i>Informações
        </h2>

        <div class="fundo">
            <table>
                <thead>
                    <tr>
                        <th>Atividades</th>
                        <th>Notas</th>
                        <th>Faltas</th>
                        <th>Data</th>
                        <th>Nota Final</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="atividade">ADO 1</td>
                        <td class="nota">2</td>
                        <td class="faltas">0</td>
                        <td class="data">03/09/2024</td>
                        <td class="nota-final">10</td>

                    </tr>
                    <tr>
                        <td class="atividade">ADO 2</td>
                        <td class="nota">2</td>
                        <td class="faltas">0</td>
                        <td class="data">10/09/2024</td>
                        
                        

                    </tr>
                    <tr>
                        <td class="atividade">ADO 3</td>
                        <td class="nota">2</td>
                        <td class="faltas">0</td>
                        <td class="data">13/09/2024</td>
                        

                    </tr>
                    <tr>
                        <td class="atividade">PROVA</td>
                        <td class="nota">4</td>
                        <td class="faltas">0</td>
                        <td class="data">20/09/2024</td>
                       

                    </tr>


                    <!-- Continue adicionando as outras linhas de dados conforme necessário -->
                </tbody>
            </table>
        </div>



    </div>

    <script src="js/scriptAluno.js"></script>
</body>
</html>