package br.com.institutoensino.dao;

import br.com.institutoensino.model.Curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CursoDao {

    public void createCurso(Curso curso){
        String SQL = "INSERT INTO CURSO (NOME, MODALIDADE, DURACAO, CAMPUS, TURNO, DESCRICAO) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, curso.getNome());
            preparedStatement.setString(2, curso.getModalidade());
            preparedStatement.setFloat(3, curso.getDuracao());
            preparedStatement.setString(4, curso.getCampus());
            preparedStatement.setString(5, curso.getTurno());
            preparedStatement.setString(6, curso.getDescricao());
            preparedStatement.execute();

            System.out.println("success in insert curso");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection curso "+ e.getMessage());

        }
    }

    public List<Curso> findAllCursos() {

        String SQL = "SELECT * FROM CURSO";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Curso> cursos = new ArrayList<>();

            while (resultSet.next()) {

                String cursoNome = resultSet.getString("curso-nome");
                String cursoModalidade = resultSet.getString("curso-modalidade");
                String cursoDuracaoStr = resultSet.getString("curso-duracao");
                String cursoCampus = resultSet.getString("curso-campus");
                String cursoTurno = resultSet.getString("curso-turno");
                String cursoDescricao = resultSet.getString("curso-descricao");

                Float cursoDuracao = null; // Inicializa como null

                cursoDuracao = Float.parseFloat(cursoDuracaoStr);

                Curso curso = new Curso(cursoNome, cursoModalidade,cursoDuracao, cursoCampus, cursoTurno, cursoDescricao);

                cursos.add(curso);

            }

            System.out.println("success in select * curso");

            connection.close();

            return cursos;

        } catch (Exception e) {

            System.out.println("fail in database connection");

            return Collections.emptyList();

        }

    }
}
