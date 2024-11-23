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
),
    Is_Admin BOOLEAN DEFAULT FALSE

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
    ID_Curso
    INT,
    FOREIGN KEY
(
    ID_Usuario
) REFERENCES USUARIO
(
    ID_Usuario
),
    FOREIGN KEY
(
    ID_Curso
) REFERENCES CURSO
(
    ID_Curso
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


INSERT INTO CURSO (NOME, MODALIDADE, DURACAO, CAMPUS, TURNO, DESCRICAO)
VALUES
    ('Economia', 'Presencial', 4.0, 'Campus Central', 'Diurno', 'Curso voltado para a compreensão dos processos econômicos e financeiros.'),
    ('Marketing Digital', 'EAD', 2.0, 'Campus Virtual', 'Noturno', 'Curso focado em estratégias de marketing no ambiente digital.'),
    ('Direito', 'Presencial', 5.0, 'Campus Leste', 'Diurno', 'Curso que forma profissionais para atuarem em áreas jurídicas.'),
    ('Excel', 'EAD', 0.5, 'Campus Virtual', 'Noturno', 'Curso de curta duração sobre técnicas avançadas em Excel.');

-- Insert professors into USUARIO table
INSERT INTO USUARIO (Nome, Email, Senha, Nascimento, CPF, RG, Logradouro, Numero, Complemento, Bairro, Cidade, Estado, Telefone_Comercial, Celular, Is_Admin)
VALUES
    ('Professor A', 'professor_a@example.com', 'senha123', '1980-01-01', '111.111.111-11', 'MG-11.111.111', 'Rua A', 101, 'Sala 1', 'Centro', 'Cidade A', 'MG', '(31) 1234-5678', '(31) 91234-5678', FALSE);

INSERT INTO PROFESSOR (ID_Usuario, Salario)
VALUES ((SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_a@example.com'), 5000.00);

INSERT INTO USUARIO (Nome, Email, Senha, Nascimento, CPF, RG, Logradouro, Numero, Complemento, Bairro, Cidade, Estado, Telefone_Comercial, Celular, Is_Admin)
VALUES
    ('Professor B', 'professor_b@example.com', 'senha123', '1985-03-20', '222.222.222-22', 'MG-22.222.222', 'Rua B', 202, 'Apto 2', 'Jardim', 'Cidade B', 'RJ', '(21) 2345-6789', '(21) 92345-6789', FALSE);

INSERT INTO PROFESSOR (ID_Usuario, Salario)
VALUES ((SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_b@example.com'), 5200.00);

INSERT INTO USUARIO (Nome, Email, Senha, Nascimento, CPF, RG, Logradouro, Numero, Complemento, Bairro, Cidade, Estado, Telefone_Comercial, Celular, Is_Admin)
VALUES
    ('Professor C', 'professor_c@example.com', 'senha123', '1978-11-15', '333.333.333-33', 'MG-33.333.333', 'Rua C', 303, 'Casa', 'Bela Vista', 'Cidade C', 'MG', '(31) 3456-7890', '(31) 93456-7890', FALSE);

INSERT INTO PROFESSOR (ID_Usuario, Salario)
VALUES ((SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_c@example.com'), 4200.00);

INSERT INTO USUARIO (Nome, Email, Senha, Nascimento, CPF, RG, Logradouro, Numero, Complemento, Bairro, Cidade, Estado, Telefone_Comercial, Celular, Is_Admin)
VALUES
    ('Professor D', 'professor_d@example.com', 'senha123', '1990-07-25', '444.444.444-44', 'MG-44.444.444', 'Rua D', 404, 'Casa 2', 'Industrial', 'Cidade D', 'BA', '(71) 4567-8901', '(71) 94567-8901', FALSE);

INSERT INTO PROFESSOR (ID_Usuario, Salario)
VALUES ((SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_d@example.com'), 4300.00);

INSERT INTO MATERIA (Nome, ID_Curso, ID_Professor)
VALUES
    ('Microeconomia', (SELECT ID_CURSO FROM CURSO WHERE NOME = 'Economia'), (SELECT ID_Professor FROM PROFESSOR WHERE ID_Usuario = (SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_a@example.com'))),
    ('Macroeconomia', (SELECT ID_CURSO FROM CURSO WHERE NOME = 'Economia'), (SELECT ID_Professor FROM PROFESSOR WHERE ID_Usuario = (SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_a@example.com'))),
    ('Econometria', (SELECT ID_CURSO FROM CURSO WHERE NOME = 'Economia'), (SELECT ID_Professor FROM PROFESSOR WHERE ID_Usuario = (SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_a@example.com'))),

    ('SEO e Marketing de Conteúdo', (SELECT ID_CURSO FROM CURSO WHERE NOME = 'Marketing Digital'), (SELECT ID_Professor FROM PROFESSOR WHERE ID_Usuario = (SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_b@example.com'))),
    ('Publicidade Online', (SELECT ID_CURSO FROM CURSO WHERE NOME = 'Marketing Digital'), (SELECT ID_Professor FROM PROFESSOR WHERE ID_Usuario = (SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_b@example.com'))),
    ('Gestão de Redes Sociais', (SELECT ID_CURSO FROM CURSO WHERE NOME = 'Marketing Digital'), (SELECT ID_Professor FROM PROFESSOR WHERE ID_Usuario = (SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_b@example.com'))),

    ('Direito Constitucional', (SELECT ID_CURSO FROM CURSO WHERE NOME = 'Direito'), (SELECT ID_Professor FROM PROFESSOR WHERE ID_Usuario = (SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_c@example.com'))),
    ('Direito Penal', (SELECT ID_CURSO FROM CURSO WHERE NOME = 'Direito'), (SELECT ID_Professor FROM PROFESSOR WHERE ID_Usuario = (SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_c@example.com'))),
    ('Direito Civil', (SELECT ID_CURSO FROM CURSO WHERE NOME = 'Direito'), (SELECT ID_Professor FROM PROFESSOR WHERE ID_Usuario = (SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_c@example.com'))),

    ('Excel Básico', (SELECT ID_CURSO FROM CURSO WHERE NOME = 'Excel'), (SELECT ID_Professor FROM PROFESSOR WHERE ID_Usuario = (SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_d@example.com'))),
    ('Excel Intermediário', (SELECT ID_CURSO FROM CURSO WHERE NOME = 'Excel'), (SELECT ID_Professor FROM PROFESSOR WHERE ID_Usuario = (SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_d@example.com'))),
    ('Excel Avançado', (SELECT ID_CURSO FROM CURSO WHERE NOME = 'Excel'), (SELECT ID_Professor FROM PROFESSOR WHERE ID_Usuario = (SELECT ID_Usuario FROM USUARIO WHERE Email = 'professor_d@example.com')));