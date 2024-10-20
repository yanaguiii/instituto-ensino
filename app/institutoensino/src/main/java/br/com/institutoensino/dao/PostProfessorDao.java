package br.com.institutoensino.dao;

import br.com.institutoensino.model.PostProfessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

    public List<PostProfessor> findAllPostProfessores() {
        String SQL = "SELECT * FROM POST_PROFESSOR";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<PostProfessor> postProfessores = new ArrayList<>();

            while (resultSet.next()) {
                int idPost = resultSet.getInt("ID_POST");
                String conteudo = resultSet.getString("CONTEUDO");
                Date data = resultSet.getDate("DATA");
                int idProfessor = resultSet.getInt("ID_PROFESSOR");
                int idMateria = resultSet.getInt("ID_MATERIA");


                PostProfessor postProfessor = new PostProfessor(idPost, conteudo, data, idProfessor, idMateria);
                postProfessores.add(postProfessor);
            }

            System.out.println("success in select * postProfessor");
            connection.close();

            return postProfessores;

        } catch (Exception e) {
            System.out.println("fail in database connection");

            return Collections.emptyList();
        }
    }

    public void deletePostProfessorById(int idPost) {
        String SQL = "DELETE FROM POST_PROFESSOR WHERE ID_POST = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idPost);
            preparedStatement.execute();

            System.out.println("success in delete postProfessor with id " + idPost);
            connection.close();

        } catch (Exception e) {
            System.out.println("fail in database connection postProfessor " + e.getMessage());
        }
    }

}
