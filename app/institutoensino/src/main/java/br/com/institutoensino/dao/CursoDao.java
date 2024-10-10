package br.com.institutoensino.dao;

import br.com.institutoensino.model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CursoDao {

    public void createCurso(Curso curso){
        String SQL = "INSERT INTO CURSO (NOME, MODALIDADE, DURACAO, CAMPUS, TURNO, DESCRICAO) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {

            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, curso.getNome());
            preparedStatement.setString(2, curso.getModalidade());
            preparedStatement.setFloat(3, curso.getDuracao());
            preparedStatement.setString(4, curso.getCampus());
            preparedStatement.setString(5, curso.getTurno());
            preparedStatement.setString(6, curso.getDescricao());
            preparedStatement.execute();

            System.out.println("success in insert curso");
            preparedStatement.close();

        } catch (Exception e) {

            System.out.println("fail in database connection curso " + e.getMessage());

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
                String cursoNome = resultSet.getString("NOME");
                String cursoModalidade = resultSet.getString("MODALIDADE");
                float cursoDuracao = resultSet.getFloat("DURACAO");
                String cursoCampus = resultSet.getString("CAMPUS");
                String cursoTurno = resultSet.getString("TURNO");
                String cursoDescricao = resultSet.getString("DESCRICAO");

                Curso curso = new Curso(cursoNome, cursoModalidade, cursoDuracao, cursoCampus, cursoTurno, cursoDescricao);
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
