CREATE TABLE IF NOT EXISTS CURSO (
    ID_Curso INT PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(255),
    MODALIDADE VARCHAR(255),
    DURACAO FLOAT,
    CAMPUS VARCHAR(255),
    TURNO VARCHAR(255),
    DESCRICAO VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS USUARIO (
    ID_Usuario INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(255),
    Email VARCHAR(255),
    Senha VARCHAR(255),
    Nascimento DATE,
    CPF VARCHAR(14),
    RG VARCHAR(20),
    Logradouro VARCHAR(255),
    Numero INT,
    Complemento VARCHAR(255),
    Bairro VARCHAR(255),
    Cidade VARCHAR(255),
    Estado VARCHAR(2), -- Geralmente, o estado é representado por uma sigla de 2 caracteres (ex: SP, RJ)
    Telefone_Comercial VARCHAR(15),
    Celular VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS PROFESSOR (
    ID_Professor INT PRIMARY KEY AUTO_INCREMENT,
    ID_Usuario INT,  -- Herança da tabela Usuário
    Salario DECIMAL(10, 2), -- Campo para o salário do professor
    FOREIGN KEY (ID_Usuario) REFERENCES USUARIO(ID_Usuario) -- Conecta com a tabela Usuário
);

CREATE TABLE IF NOT EXISTS ALUNO (
    ID_Aluno INT PRIMARY KEY AUTO_INCREMENT,
    ID_Usuario INT,
    Matricula VARCHAR(50),
    FOREIGN KEY (ID_Usuario) REFERENCES USUARIO(ID_Usuario)
);

CREATE TABLE IF NOT EXISTS MATERIA (
    ID_Materia INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(255),
    ID_Curso INT, -- FK para o curso a que a matéria pertence
    ID_Professor INT, -- FK para o professor que ministra a matéria
    FOREIGN KEY (ID_Curso) REFERENCES CURSO(ID_Curso),
    FOREIGN KEY (ID_Professor) REFERENCES PROFESSOR(ID_Professor)
);


CREATE TABLE IF NOT EXISTS ALUNO_MATERIA (
    ID_Aluno INT,
    ID_Materia INT,
    Nota DECIMAL(5, 2), -- A nota do aluno na matéria
    Faltas INT, -- Quantidade de faltas do aluno na matéria
    FOREIGN KEY (ID_Aluno) REFERENCES ALUNO(ID_Aluno),
    FOREIGN KEY (ID_Materia) REFERENCES MATERIA(ID_Materia),
    PRIMARY KEY (ID_Aluno, ID_Materia)
);

-- Tabela Post_Professor
CREATE TABLE IF NOT EXISTS POST_PROFESSOR (
    ID_Post INT PRIMARY KEY AUTO_INCREMENT,
    Conteudo TEXT, -- Utilizando TEXT para permitir postagens maiores
    Data DATE, -- Tipo DATE para armazenar a data do post
    ID_Professor INT, -- FK para o professor que fez o post
    ID_Materia INT, -- FK para a matéria a que o post está relacionado
    FOREIGN KEY (ID_Professor) REFERENCES PROFESSOR(ID_Professor),
    FOREIGN KEY (ID_Materia) REFERENCES MATERIA(ID_Materia)
);