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


-- Insert courses if they don't exist
INSERT INTO CURSO (NOME, MODALIDADE, DURACAO, CAMPUS, TURNO, DESCRICAO)
SELECT * FROM (
                  SELECT 'Economia' AS NOME, 'Presencial' AS MODALIDADE, 4.0 AS DURACAO, 'Campus Central' AS CAMPUS, 'Diurno' AS TURNO, 'Curso voltado para a compreensão dos processos econômicos e financeiros.' AS DESCRICAO
                  UNION ALL SELECT 'Marketing Digital', 'EAD', 2.0, 'Campus Virtual', 'Noturno', 'Curso focado em estratégias de marketing no ambiente digital.'
                  UNION ALL SELECT 'Direito', 'Presencial', 5.0, 'Campus Leste', 'Diurno', 'Curso que forma profissionais para atuarem em áreas jurídicas.'
                  UNION ALL SELECT 'Excel', 'EAD', 0.5, 'Campus Virtual', 'Noturno', 'Curso de curta duração sobre técnicas avançadas em Excel.'
              ) AS temp
WHERE NOT EXISTS (SELECT 1 FROM CURSO WHERE NOME = temp.NOME);

-- Insert professors into USUARIO table if they don't exist
INSERT INTO USUARIO (Nome, Email, Senha, Nascimento, CPF, RG, Logradouro, Numero, Complemento, Bairro, Cidade, Estado, Telefone_Comercial, Celular, Is_Admin)
SELECT * FROM (
                  SELECT 'Professor A' AS Nome, 'professor_a@example.com' AS Email, 'senha123' AS Senha, '1980-01-01' AS Nascimento, '111.111.111-11' AS CPF, 'MG-11.111.111' AS RG, 'Rua A' AS Logradouro, 101 AS Numero, 'Sala 1' AS Complemento, 'Centro' AS Bairro, 'Cidade A' AS Cidade, 'MG' AS Estado, '(31) 1234-5678' AS Telefone_Comercial, '(31) 91234-5678' AS Celular, FALSE AS Is_Admin
                  UNION ALL SELECT 'Professor B', 'professor_b@example.com', 'senha123', '1985-03-20', '222.222.222-22', 'MG-22.222.222', 'Rua B', 202, 'Apto 2', 'Jardim', 'Cidade B', 'RJ', '(21) 2345-6789', '(21) 92345-6789', FALSE
                  UNION ALL SELECT 'Professor C', 'professor_c@example.com', 'senha123', '1978-11-15', '333.333.333-33', 'MG-33.333.333', 'Rua C', 303, 'Casa', 'Bela Vista', 'Cidade C', 'MG', '(31) 3456-7890', '(31) 93456-7890', FALSE
                  UNION ALL SELECT 'Professor D', 'professor_d@example.com', 'senha123', '1990-07-25', '444.444.444-44', 'MG-44.444.444', 'Rua D', 404, 'Casa 2', 'Industrial', 'Cidade D', 'BA', '(71) 4567-8901', '(71) 94567-8901', FALSE
              ) AS temp
WHERE NOT EXISTS (SELECT 1 FROM USUARIO WHERE Email = temp.Email);

-- Insert professors if they don't exist
INSERT INTO PROFESSOR (ID_Usuario, Salario)
SELECT ID_Usuario, 5000.00 FROM USUARIO WHERE Email = 'professor_a@example.com' AND NOT EXISTS (SELECT 1 FROM PROFESSOR WHERE ID_Usuario = USUARIO.ID_Usuario);

INSERT INTO PROFESSOR (ID_Usuario, Salario)
SELECT ID_Usuario, 5200.00 FROM USUARIO WHERE Email = 'professor_b@example.com' AND NOT EXISTS (SELECT 1 FROM PROFESSOR WHERE ID_Usuario = USUARIO.ID_Usuario);

INSERT INTO PROFESSOR (ID_Usuario, Salario)
SELECT ID_Usuario, 4200.00 FROM USUARIO WHERE Email = 'professor_c@example.com' AND NOT EXISTS (SELECT 1 FROM PROFESSOR WHERE ID_Usuario = USUARIO.ID_Usuario);

INSERT INTO PROFESSOR (ID_Usuario, Salario)
SELECT ID_Usuario, 4300.00 FROM USUARIO WHERE Email = 'professor_d@example.com' AND NOT EXISTS (SELECT 1 FROM PROFESSOR WHERE ID_Usuario = USUARIO.ID_Usuario);

-- Insert subjects if they don't exist
INSERT INTO MATERIA (Nome, ID_Curso, ID_Professor)
SELECT m.Nome, c.ID_Curso, p.ID_Professor
FROM (
         SELECT 'Microeconomia' AS Nome, 'Economia' AS Curso, 'professor_a@example.com' AS ProfEmail
         UNION ALL SELECT 'Macroeconomia', 'Economia', 'professor_a@example.com'
         UNION ALL SELECT 'Econometria', 'Economia', 'professor_a@example.com'
         UNION ALL SELECT 'SEO e Marketing de Conteúdo', 'Marketing Digital', 'professor_b@example.com'
         UNION ALL SELECT 'Publicidade Online', 'Marketing Digital', 'professor_b@example.com'
         UNION ALL SELECT 'Gestão de Redes Sociais', 'Marketing Digital', 'professor_b@example.com'
         UNION ALL SELECT 'Direito Constitucional', 'Direito', 'professor_c@example.com'
         UNION ALL SELECT 'Direito Penal', 'Direito', 'professor_c@example.com'
         UNION ALL SELECT 'Direito Civil', 'Direito', 'professor_c@example.com'
         UNION ALL SELECT 'Excel Básico', 'Excel', 'professor_d@example.com'
         UNION ALL SELECT 'Excel Intermediário', 'Excel', 'professor_d@example.com'
         UNION ALL SELECT 'Excel Avançado', 'Excel', 'professor_d@example.com'
     ) AS m
         JOIN CURSO c ON c.NOME = m.Curso
         JOIN USUARIO u ON u.Email = m.ProfEmail
         JOIN PROFESSOR p ON p.ID_Usuario = u.ID_Usuario
WHERE NOT EXISTS (
    SELECT 1 FROM MATERIA
    WHERE Nome = m.Nome AND ID_Curso = c.ID_Curso AND ID_Professor = p.ID_Professor
);