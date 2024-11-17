CREATE TABLE IF NOT EXISTS CURSO
(
    ID_Curso
    INT
    PRIMARY
    KEY
    AUTO_INCREMENT,
    NOME
    VARCHAR
(
    255
),
    MODALIDADE VARCHAR
(
    255
),
    DURACAO FLOAT,
    CAMPUS VARCHAR
(
    255
),
    TURNO VARCHAR
(
    255
),
    DESCRICAO VARCHAR
(
    500
)
    );

CREATE TABLE IF NOT EXISTS USUARIO
(
    ID_Usuario
    INT
    PRIMARY
    KEY
    AUTO_INCREMENT,
    Nome
    VARCHAR
(
    255
),
    Email VARCHAR
(
    255
),
    Senha VARCHAR
(
    255
),
    Nascimento DATE,
    CPF VARCHAR
(
    14
),
    RG VARCHAR
(
    20
),
    Logradouro VARCHAR
(
    255
),
    Numero INT,
    Complemento VARCHAR
(
    255
),
    Bairro VARCHAR
(
    255
),
    Cidade VARCHAR
(
    255
),
    Estado VARCHAR
(
    2
),
    Telefone_Comercial VARCHAR
(
    15
),
    Celular VARCHAR
(
    15
)
    );

CREATE TABLE IF NOT EXISTS PROFESSOR
(
    ID_Professor
    INT
    PRIMARY
    KEY
    AUTO_INCREMENT,
    ID_Usuario
    INT,
    Salario
    DECIMAL
(
    10,
    2
),
    FOREIGN KEY
(
    ID_Usuario
) REFERENCES USUARIO
(
    ID_Usuario
)
    );

CREATE TABLE IF NOT EXISTS ALUNO
(
    ID_Aluno
    INT
    PRIMARY
    KEY
    AUTO_INCREMENT,
    ID_Usuario
    INT,
    FOREIGN KEY
(
    ID_Usuario
) REFERENCES USUARIO
(
    ID_Usuario
)
    );

CREATE TABLE IF NOT EXISTS MATERIA
(
    ID_Materia
    INT
    PRIMARY
    KEY
    AUTO_INCREMENT,
    Nome
    VARCHAR
(
    255
),
    ID_Curso INT,
    ID_Professor INT,
    FOREIGN KEY
(
    ID_Curso
) REFERENCES CURSO
(
    ID_Curso
),
    FOREIGN KEY
(
    ID_Professor
) REFERENCES PROFESSOR
(
    ID_Professor
)
    );


CREATE TABLE IF NOT EXISTS ALUNO_MATERIA
(
    ID_Aluno
    INT,
    ID_Materia
    INT,
    Nota
    DECIMAL
(
    5,
    2
),
    Faltas INT,
    FOREIGN KEY
(
    ID_Aluno
) REFERENCES ALUNO
(
    ID_Aluno
),
    FOREIGN KEY
(
    ID_Materia
) REFERENCES MATERIA
(
    ID_Materia
),
    PRIMARY KEY
(
    ID_Aluno,
    ID_Materia
)
    );


CREATE TABLE IF NOT EXISTS POST_PROFESSOR
(
    ID_Post
    INT
    PRIMARY
    KEY
    AUTO_INCREMENT,
    Conteudo
    TEXT,
    Data
    DATE,
    ID_Professor
    INT,
    ID_Materia
    INT,
    FOREIGN
    KEY
(
    ID_Professor
) REFERENCES PROFESSOR
(
    ID_Professor
),
    FOREIGN KEY
(
    ID_Materia
) REFERENCES MATERIA
(
    ID_Materia
)
    );