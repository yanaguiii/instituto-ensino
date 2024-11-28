#InstitutoEnsino

Tela Home

    Cabeçalho:
        - Logo e nome da empresa à esquerda
        - Área de login/logout à direita
        - Botão para acessar informações do aluno/professor à esquerda da área de acesso
    Área central:
        - Imagem do campus abaixo do cabeçalho
        - Barra de pesquisa de cursos entre a imagem e o carrossel
        - Carrossel de cursos com cards contendo:
        - Imagem ilustrativa do curso
        - Título do curso
        - Breve descrição
        - Botão "Saiba Mais" (abre popup com detalhes do curso)
    Popup de detalhes do curso:
        - Nome da instituição e do curso
        - Descrição detalhada
        - Quatro "balões" com informações: Modalidade, Duração, Campus, Horários
        - Imagem ilustrativa à esquerda
        - Lista de matérias do curso à direita
        - Botão "Cadastre-se" no centro inferior
    Rodapé:
        - Informações de contato da instituição
        - Lista de empresas parceiras
        - Breve descrição sobre a instituição

Tela de Login

    - Campos de entrada para e-mail e senha
    - Botão "Acessar" para efetuar login
    - Botão "Escolha um curso e cadastre-se" para novos usuários
    - Logo da empresa no canto superior direito (link para home)
    - Fundo dividido diagonalmente em branco e verde

Tela de Cadastro

    - Seções de cadastro:
      - Dados para login: E-mail, confirmação de e-mail, senha, confirmação de senha
      - Dados Pessoais: Nome completo, data de nascimento, RG, CPF
      - Dados Residenciais: Logradouro, número, complemento (opcional), bairro, cidade, estado
      - Contato: Telefone comercial (opcional), celular
    - Botões de cadastro e retorno à home
    - Link para tela de login (para usuários já cadastrados)

Tela do Professor

    Menu lateral:
        - Nome da empresa
        - Lista de matérias ministradas pelo professor
        - Botão de logout
    Cabeçalho:
        - Mensagem de boas-vindas personalizada
        - Título "Gestão de Alunos"
        - Logo da empresa (link para home)
    Conteúdo principal:
        - Tabelas de alunos para cada matéria (nome, faltas, nota final, ações)
        - Campo para criar posts por matéria
        - Botão "Modificar" para editar notas e faltas dos alunos

Tela do Aluno

    Menu lateral:
        - Nome da empresa
        - Curso do aluno
        - Botão de logout
    Cabeçalho:
        - Mensagem de boas-vindas personalizada
        - Título "Quadro do Aluno"
        - Logo da empresa (link para home)
    Conteúdo principal:
        - Quadro de posts dos professores (central)
        - Tabela de notas e faltas por matéria (abaixo do quadro de posts)

Funcionalidades Principais

    - Gerenciamento completo de cursos e matérias
    - Sistema de cadastro e autenticação de usuários (alunos e professores)
    - Painel administrativo para gestão do sistema
    - Sistema de posts para comunicação entre professores e alunos
    - Registro e visualização de notas e faltas
    - Pesquisa de cursos na página inicial

Telas ja implementadas (01/11/2024)
- Tela de home: contém um carrossel dos cursos, que podem ser clicados para exibir detalhes. Botão de login no canto superior direito (que leva a tela de login), seguido do botão da área administrativa (que leva para a index.jsp).
- Tela de login: contem dois inputs para login, hyperlink no título (provisório) para voltar a home, e botão para voltar a tela de cadastro.
- Tela de cadastro: cadastro de usuário, com botão para tela de login.
- Tela de index: para criação de qualquer elemento das tabelas pertinentes a instituição. Contém botões embaixo para fácil acesso.
- Tela de dashboard: exibe todas as tabelas e seus elementos. Contém botões embaixo para fácil acesso.

#Diagramas

![Diagrama DER](/images/DER.png)
![Diagrama MER](/images/MER.PNG)

#prototipos 
![Diagrama MER](/images/telahome.png)
![Diagrama MER](/images/telalogin.png)
![Diagrama MER](/images/telaprofessor.png)
![Diagrama MER](/images/telaaluno.png)
![Diagrama MER](/images/telacadastro.png)
![Diagrama MER](/images/telacurso1.png)
![Diagrama MER](/images/telacurso2.png)
![Diagrama MER](/images/telacurso3.png)
![Diagrama MER](/images/telacurso4.png)

