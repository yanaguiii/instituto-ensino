package br.com.institutoensino.dao;

import br.com.institutoensino.model.PostProfessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PostProfessorDao {

    public void createPostProfessor(PostProfessor postProfessor) {
        String SQL = "INSERT INTO POST_PROFESSOR (CONTEUDO, DATA, ID_PROFESSOR, ID_MATERIA) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, postProfessor.getConteudo());
            preparedStatement.setDate(2, new java.sql.Date(postProfessor.getData().getTime()));
            preparedStatement.setInt(3, postProfessor.getIdProfessor());
            preparedStatement.setInt(4, postProfessor.getIdMateria());
            preparedStatement.execute();

            System.out.println("success in insert postProfessor");
            connection.close();
        } catch (Exception e) {
            System.out.println("fail in database connection postProfessor " + e.getMessage());
        }
    }
}
