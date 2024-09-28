package br.com.institutoensino.dao;

import br.com.institutoensino.model.Curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

            System.out.println("fail in database connection CURSO "+ e.getMessage());

        }
    }
}
