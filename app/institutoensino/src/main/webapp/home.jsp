<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Instituto Ensino - Home</title>
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />
    <link rel="stylesheet" href="css/home.css">
</head>

<body>

<header>
    <div class="header-content">
        <div class="logo">
            <img src="images/logo.png" alt="logo">
        </div>
        <div class="Nomedainstituicao">
            <h1>Instituto Ensino</h1>
        </div>
    </div>

    <div class="login">
        <i class='bx bx-log-in'></i>
        <a href="login.jsp" class="login-link">
            <button class="sign-in-btn">Login</button>
        </a>
    </div>
</header>


<div class="header-image">
        <img src="images/background3.png" alt="imagem ilustrativa">
    </div>

    <div class="search-container">
        <div class="search-bar">
            <input type="text" placeholder="O que você procura?">
            <i class='bx bx-search'></i>
        </div>
    </div>

    <div class="swiper mySwiper">
        <div class="swiper-wrapper">
            <!-- Slide 1 -->
            <div class="swiper-slide">
                <img src="images/c1.jpg" alt="Imagem 1" class="slide-image">
                <h4 class="slide-title">Aprenda Marketing Digital</h4>
                <p class="slide-text">Aprenda a promover marcas online com SEO, redes sociais, campanhas pagas e análise de dados.</p>
                <button class="slide-button" onclick="openPopup('popupMarketing')">Saiba Mais</button>

            </div>

            <!-- Slide 2 -->
            <div class="swiper-slide">
                <img src="images/c2.jpg" alt="Imagem 2" class="slide-image">
                <h4 class="slide-title">Aprenda Direito</h4>
                <p class="slide-text">Estude leis e normas, desenvolvendo habilidades de argumentação e resolução de conflitos.</p>
                <button class="slide-button" onclick="openPopup('popupDireito')">Saiba Mais</button>
            </div>


            <div class="swiper-slide">
                <img src="images/c3.jpg" alt="Imagem 3" class="slide-image">
                <h4 class="slide-title">Aprenda Excel</h4>
                <p class="slide-text">Desenvolva habilidades em Excel do básico ao intermediário para gerenciar e analisar dados de forma eficaz.</p>
                <button class="slide-button" onclick="openPopup('popupExcel')">Saiba Mais</button>
            </div>


            <div class="swiper-slide">
                <img src="images/c4.jpg" alt="Imagem 4" class="slide-image">
                <h4 class="slide-title">Aprenda Economia</h4>
                <p class="slide-text">Aprenda a analisar mercados, distribuição de recursos e políticas econômicas, para atuar em finanças, consultoria entre outros.</p>
                <button class="slide-button" onclick="openPopup('popupEconomia')">Saiba Mais</button>
            </div>

        </div>

        <!-- Controles do Swiper -->
        <div class="swiper-button-next"></div>
        <div class="swiper-button-prev"></div>
        <div class="swiper-pagination"></div>
    </div>

<div id="popupMarketing" class="popup">
    <div class="popup-content">
        <span id="closePopupBtn" class="close">&times;</span>

        <!-- Cabeçalho do popup -->
        <div class="headerpopup">
            <h2>Curso Instituto Ensino</h2>
            <h3>Marketing Digital</h3>
            <p><strong>Sobre o curso:</strong> No curso de Marketing Digital, você aprende a promover marcas e
                produtos online. Estuda estratégias para SEO, gestão de mídias sociais,
                criação de campanhas publicitárias pagas, e-mail marketing e marketing de conteúdo.
                Também aprende a analisar dados e métricas para avaliar o desempenho das campanhas e entender o
                comportamento do consumidor digital.
                O curso visa desenvolver habilidades para otimizar a presença online das empresas e aumentar o
                engajamento com o público.
            </p>
        </div>
        <!-- Detalhes do curso -->
        <div class="detalhes">
            <div class="info"><strong>Modalidade:</strong> <span>PRESENCIAL</span></div>
            <div class="info"><strong>Duração:</strong> <span>1200 horas</span></div>
            <div class="info"><strong>Campus:</strong> <span>Santo Amaro - SP</span></div>
            <div class="info"><strong>Horários:</strong> <span>Segunda a Sexta - 14:30</span></div>
        </div>

        <!-- Texto e imagem lado a lado -->
        <div class="text-image-container">
            <img src="images/marketing.jpeg" alt="Gráfico de Exemplo">
            <div class="text">
                <h4>O que você vai aprender:</h4>
                <ul>
                    <li>Introdução ao Marketing Digital</li>
                    <li>Google e Mídias Sociais</li>
                    <li>SEO (Otimização para Motores de Busca)</li>
                    <li>Marketing e Métricas</li>
                </ul>
            </div>
        </div>
    </div>
</div>



<div id="popupExcel" class="popup">
    <div class="popup-content">
        <span id="closePopupBtn" class="close">&times;</span>

        <!-- Cabeçalho do popup -->
        <div class="headerpopup">
            <h2>Curso Instituto Ensino</h2>
            <h3>Excel – do básico ao intermediário</h3>
            <p><strong>Sobre o curso:</strong> Neste curso, você desenvolverá as habilidades necessárias em Excel, do básico ao intermediário, para poder lidar com as funcionalidades necessárias para realizar um trabalho inicial de gerenciamento ou análise de dados.
            </p>
        </div>
        <!-- Detalhes do curso -->
        <div class="detalhes">
            <div class="info"><strong>Modalidade:</strong> <span>EAD</span></div>
            <div class="info"><strong>Duração:</strong> <span>120 horas</span></div>
            <div class="info"><strong>Campus:</strong> <span>Santo Amaro - SP</span></div>
            <div class="info"><strong>Horários:</strong> <span>Segunda e Quartas - 13:30</span></div>
        </div>

        <!-- Texto e imagem lado a lado -->
        <div class="text-image-container">
            <img src="images/excel.jpeg" alt="Gráfico de Exemplo">
            <div class="text">
                <h4>O que você vai aprender:</h4>
                <ul>
                    <li>Introdução ao Excel</li>
                    <li>Formatação de Células e Planilhas</li>
                    <li>Funções Básicas (SOMA, MÉDIA, etc.)</li>
                    <li>Funções Avançadas (PROCV, ÍNDICE, CORRESP, etc.)</li>
                    <li>Tabelas e Gráficos Dinâmicos</li>
                    <li>Análise de Dados</li>
                </ul>
            </div>
        </div>
    </div>
</div>


<div id="popupDireito" class="popup">
    <div class="popup-content">
        <span id="closePopupBtn" class="close">&times;</span>

        <!-- Cabeçalho do popup -->
        <div class="headerpopup">
            <h2>Curso Instituto Ensino</h2>
            <h3>Direito</h3>
            <p><strong>Sobre o curso:</strong> No curso de Direito, você aprende sobre leis, normas e princípios jurídicos que regulam a sociedade. As áreas incluem direito civil, penal, constitucional, trabalhista e comercial. O curso também desenvolve habilidades de argumentação, interpretação de leis e resolução de conflitos, preparando profissionais para atuar como advogados, juízes, promotores ou consultores jurídicos.
            </p>
        </div>
        <!-- Detalhes do curso -->
        <div class="detalhes">
            <div class="info"><strong>Modalidade:</strong> <span>PRESENCIAL</span></div>
            <div class="info"><strong>Duração:</strong> <span>3700 horas</span></div>
            <div class="info"><strong>Campus:</strong> <span>Santo Amaro - SP</span></div>
            <div class="info"><strong>Horários:</strong> <span>Segunda a Sábado - 07:30</span></div>
        </div>

        <!-- Texto e imagem lado a lado -->
        <div class="text-image-container">
            <img src="images/direito.png" alt="Gráfico de Exemplo">
            <div class="text">
                <h4>O que você vai aprender:</h4>
                <ul>
                    <li>Direito Constitucional</li>
                    <li>Direito Civil</li>
                    <li>Direito Penal</li>
                    <li>Direito Administrativo</li>
                    <li>Direito do Trabalho</li>
                    <li>Direito Comercial</li>
                    <li>Direito Tributário</li>
                </ul>
            </div>
        </div>
    </div>
</div>


<div id="popupEconomia" class="popup">
    <div class="popup-content">
        <span id="closePopupBtn" class="close">&times;</span>

        <!-- Cabeçalho do popup -->
        <div class="headerpopup">
            <h2>Curso Instituto Ensino</h2>
            <h3>Economia</h3>
            <p><strong>Sobre o curso:</strong> No curso de Economia, você aprende a analisar e entender o funcionamento dos mercados, a distribuição de recursos e o comportamento dos agentes econômicos.  Também são abordados temas como economia internacional, políticas monetárias e fiscais, desenvolvimento econômico, finanças públicas, e o uso da econometria para interpretar dados. O curso prepara o aluno para atuar em áreas como análise econômica, consultoria, finanças e políticas públicas.
            </p>
        </div>
        <!-- Detalhes do curso -->
        <div class="detalhes">
            <div class="info"><strong>Modalidade:</strong> <span>PRESENCIAL</span></div>
            <div class="info"><strong>Duração:</strong> <span>3000 horas</span></div>
            <div class="info"><strong>Campus:</strong> <span>Santo Amaro - SP</span></div>
            <div class="info"><strong>Horários:</strong> <span>Segunda a Sexta - 19:00</span></div>
        </div>

        <!-- Texto e imagem lado a lado -->
        <div class="text-image-container">
            <img src="images/economia.png" alt="Gráfico de Exemplo">
            <div class="text">
                <h4>O que você vai aprender:</h4>
                <ul>
                    <li>Microeconomia</li>
                    <li>Macroeconomia</li>
                    <li>Economia Internacional</li>
                    <li>Economia Monetária</li>
                    <li>Econometria</li>
                    <li>História do Pensamento Econômico</li>
                    <li>Economia do Setor Público</li>
                </ul>
            </div>
        </div>
    </div>
</div>

    <footer>
        <div class="footer-content">
            <div class="footer-logo">
                <img src="images/logo.png" alt="Logo">
            </div>

            <div class="footer-section">
                <h4>Empresas Parceiras:</h4>
                <ul>
                    <li>Hamburgueria</li>
                </ul>
            </div>

            <div class="footer-section">
                <h4>Contato:</h4>
                <p>Email: institutoensino@gmail.com</p>
                <p>Telefone: 4002-8922</p>
            </div>

            <div class="footer-section">
                <h4>Sobre nós:</h4>
                <p>O Instituto Ensino é uma instituição dedicada à educação de qualidade, formando profissionais
                    competentes em diversas áreas. Com professores experientes e ambiente moderno, promove aprendizado e desenvolvimento
                    pessoal desde 2024.</p>
            </div>

            <div class="rights">
                <p>&copy; <span id="displayYear"></span> Todos os direitos reservados por
                    <a>Instituto Ensino</a>
                </p>
            </div>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <script src="js/home.js"></script>

</body>

</html>
