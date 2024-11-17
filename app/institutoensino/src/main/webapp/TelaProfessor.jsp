<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>CodePen - Navbar Pure CSS</title>
    <link rel="stylesheet" href="../css/styleProfessor.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="../js/scriptEdit.js">
    

</head>

<body>
    <div id="nav-bar">
        <input id="nav-toggle" type="checkbox" />
        <div id="nav-header"><a id="nav-title" href="" target="_blank">Instituto Ensino</a>
            <div class="separator"></div>


            <hr />

            <label for="nav-toggle"><span id="nav-toggle-burger"></span></label>

        </div>
        <div id="nav-content">
            <div class="nav-button"><span>Acadêmico</span></div>

            <div class="nav-button"><i class="bx bx-book"></i><span>Direito</span></div>
            <div class="nav-button"><i class="bx bx-bullseye"></i><span>Marketing Digital</span></div>

            <div class="nav-button"><i class="bx bx-line-chart"></i><span>Excel</span></div>
            <div class="nav-button"><i class="bx bx-dollar"></i><span>Economia</span></div>

            <div class="separator"></div>

            
            <div class="nav-button"><i class="bx bx-log-out"></i><span>Logout</span></div>

        </div>

    </div>

    <div class="textoBoasVindas">
        <h1><span class="hand"><img src="../images/hand.png" alt="icone"></span> Bem Vindo, Professor!</h1>
    </div>


    <div class="gestao">
        <span class="icon"><i class="bx bxs-cog"></i></span>
        <h2>GESTÃO DE ALUNOS</h2>
    </div>

    <div class="separator1"></div>

    <!-- Logo no canto superior direito -->
    <div class="image-logo">
        <img src="../images/logo.png" alt="Logo">
    </div>

    <!-- Exemplo de um participante / <div class="participant-list"></div> -->

    <div class="table-container">
        <h2 class="h2escrita">

            <i class="bx bx-book icon1"></i>Participantes
        </h2>

        <table>
            <thead>
                <tr>
                    <th>Alunos</th>
                    <th>Curso</th>
                    <th>Data</th>
                    <th>Horario</th>
                    <th>Localização</th>
                    <th>Modalidade</th>
                    <th>Status</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" value="Lucas Andrade"></td>
                    <td><input type="text" value="Marketing"></td>
                    <td><input type="text" value="25 de Jan, 2024"></td>
                    <td><input type="text" value="14:30 PM"></td>
                    <td><input type="text" value="Santo Amaro - SP"></td>
                    <td><input type="text" value="Presencial"></td>
                    <td><textarea class="status-completed">Completado</textarea></td>
                    <td><button class="botao-editar">Editar</button></td>
                    <td><button class="botao-salvar">Salvar</button></td>
                </tr>
                <tr>
                    <td><input type="text" value="Camila Ferreira"></td>
                    <td><input type="text" value="Economia"></td>
                    <td><input type="text" value="5 de Fev, 2024"></td>
                    <td><input type="text" value="19:00 PM"></td>
                    <td><input type="text" value="Santo Amaro - SP"></td>
                    <td><input type="text" value="Presencial"></td>
                    <td><textarea class="status-completed">Completado</textarea></td>
                    
                </tr>
                <tr>
                    <td><input type="text" value="Gustavo Mendes"></td>
                    <td><input type="text" value="Excel"></td>
                    <td><input type="text" value="10 de Março, 2024"></td>
                    <td><input type="text" value="13:30 PM"></td>
                    <td><input type="text" value="Santo Amaro - SP"></td>
                    <td><input type="text" value="EAD"></td>
                    <td><textarea class="status-upcoming">Incompleto</textarea></td>
                </tr>
                <tr>
                    <td><input type="text" value="Mariana Oliveira"></td>
                    <td><input type="text" value="Excel"></td>
                    <td><input type="text" value="2 de Abril, 2024"></td>
                    <td><input type="text" value="13:30 PM"></td>
                    <td><input type="text" value="Santo Amaro - SP"></td>
                    <td><input type="text" value="EAD"></td>
                    <td><textarea class="status-upcoming">Incompleto</textarea></td>
                </tr>
                <tr>
                    <td><input type="text" value="Felipe Oliveira"></td>
                    <td><input type="text" value="Direito"></td>
                    <td><input type="text" value="15 de Maio, 2024"></td>
                    <td><input type="text" value="07:30 AM"></td>
                    <td><input type="text" value="Santo Amaro - SP"></td>
                    <td><input type="text" value="Presencial"></td>
                    <td><textarea class="status-upcoming">Incompleto</textarea></td>
                </tr>
                <tr>
                    <td><input type="text" value="Larissa Souza"></td>
                    <td><input type="text" value="Marketing"></td>
                    <td><input type="text" value="8 de Junho, 2024"></td>
                    <td><input type="text" value="14:30 PM"></td>
                    <td><input type="text" value="Santo Amaro - SP"></td>
                    <td><input type="text" value="Presencial"></td>
                    <td><textarea class="status-upcoming">Incompleto</textarea></td>
                </tr>
                <tr>
                    <td><input type="text" value="Rafael Costa"></td>
                    <td><input type="text" value="Economia"></td>
                    <td><input type="text" value="20 de Nov, 2024"></td>
                    <td><input type="text" value="19:00 PM"></td>
                    <td><input type="text" value="Santo Amaro - SP"></td>
                    <td><input type="text" value="Presencial"></td>
                    <td><textarea class="status-upcoming">Incompleto</textarea></td>
                </tr>
                <!-- Continue adicionando as outras linhas de dados conforme necessário -->
            </tbody>
        </table>

        

        <h2 class="h2_1escrita">

            <i class="bx bx-info-circle icon1"></i>Informações
        </h2>

        <table>
            <thead>
                <tr>
                    <th>Materias</th>
                    <th>Notas</th>
                    <th>Faltas</th>
                    <th>Contato</th>
                    <th>Atividades Entregues</th>
                   
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" value="Materia 1"></td>
                    <td><input type="text" value="10"></td>
                    <td><input type="text" value="0"></td>
                    <td><input type="text" value="(11) 99305-1052"></td>
                    <td><input type="text" value="5/5"></td>
                    
                   
                </tr>
                <tr>
                    <td><input type="text" value="Materia 2"></td>
                    <td><input type="text" value="8"></td>
                    <td><input type="text" value="1"></td>
                    <td><input type="text" value="(11) 98141-2009"></td>
                    <td><input type="text" value="4/5"></td>
                    
                    
                </tr>
                <tr>
                    <td><input type="text" value="Materia 3"></td>
                    <td><input type="text" value="6"></td>
                    <td><input type="text" value="3"></td>
                    <td><input type="text" value="(11) 98871-8270"></td>
                    <td><input type="text" value="2/5"></td>
                   
                   
                </tr>
                <tr>
                    <td><input type="text" value="Materia 4"></td>
                    <td><input type="text" value="7"></td>
                    <td><input type="text" value="2"></td>
                    <td><input type="text" value="(11) 99693-8074"></td>
                    <td><input type="text" value="3/5"></td>
                    
                    
                </tr>
                <tr>
                    <td><input type="text" value="0"></td>
                    <td><input type="text" value="0"></td>
                    <td><input type="text" value="0"></td>
                    <td><input type="text" value="0"></td>
                    <td><input type="text" value="0"></td>
                    
                    
                </tr>
                <tr>
                    <td><input type="text" value="0"></td>
                    <td><input type="text" value="0"></td>
                    <td><input type="text" value="0"></td>
                    <td><input type="text" value="0"></td>
                    <td><input type="text" value="0"></td>
                    
                </tr>
                <tr>
                    <td><input type="text" value="0"></td>
                    <td><input type="text" value="0"></td>
                    <td><input type="text" value="0"></td>
                    <td><input type="text" value="0"></td>
                    <td><input type="text" value="0"></td>
                    
                   
                </tr>
                <!-- Continue adicionando as outras linhas de dados conforme necessário -->
            </tbody>
        </table>
        
        <div>
            <h2 class="h2_2escrita">

                <i class="bx bx-edit-alt icon1"></i>Quadro de Avisos
            </h2>
            <textarea class="quadro-avisos" placeholder="Escreva os avisos aqui..."></textarea>

            <div class="BotaoEnviar">
                <h2>Deseja enviar este aviso? </h2> 
                <button class="botao">Enviar</button>
            </div>
        </div>
    
        <script src="../js/scriptQuadro.js"></script> <!--Só funciona assim não sei pq-->

    </div>                            
</body>

</html>