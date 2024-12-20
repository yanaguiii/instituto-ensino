package br.com.institutoensino.dao;

import br.com.institutoensino.config.ConnectionPoolConfig;
import br.com.institutoensino.model.PostProfessor;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class PostProfessorDao {

    public void createPostProfessor(PostProfessor postProfessor) {
        String SQL = "INSERT INTO POST_PROFESSOR (CONTEUDO, DATA, ID_PROFESSOR, ID_MATERIA) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();


            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, postProfessor.getConteudo());
            preparedStatement.setDate(2, new java.sql.Date(postProfessor.getPostData().getTime()));
            preparedStatement.setInt(3, postProfessor.getPostIdProfessor());
            preparedStatement.setInt(4, postProfessor.getPostIdMateria());
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
            Connection connection = ConnectionPoolConfig.getConnection();


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
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idPost);
            preparedStatement.execute();

            System.out.println("success in delete postProfessor with id " + idPost);
            connection.close();

        } catch (Exception e) {
            System.out.println("fail in database connection postProfessor " + e.getMessage());
        }
    }

    public void updatePostProfessor(PostProfessor postProfessor) {
        // String SQL para a atualização do post do professor
        String SQL = "UPDATE POST_PROFESSOR SET CONTEUDO = ?, DATA = ?, ID_PROFESSOR = ?, ID_MATERIA = ? WHERE ID_POST = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();


            // Preparando o statement
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1, postProfessor.getConteudo() != null && !postProfessor.getConteudo().isEmpty() ? postProfessor.getConteudo() : null);
            preparedStatement.setObject(2, postProfessor.getPostData() != null ? new java.sql.Date(postProfessor.getPostData().getTime()) : null);
            preparedStatement.setObject(3, postProfessor.getPostIdProfessor() > 0 ? postProfessor.getPostIdProfessor() : null);
            preparedStatement.setObject(4, postProfessor.getPostIdMateria() > 0 ? postProfessor.getPostIdMateria() : null);
            preparedStatement.setInt(5, postProfessor.getIdPost()); // Adicionando o ID do post para a cláusula WHERE

            // Executando a atualização
            int rowsAffected = preparedStatement.executeUpdate(); // Use executeUpdate para um UPDATE

            if (rowsAffected > 0) {
                System.out.println("success in update postProfessor with id " + postProfessor.getIdPost());
            } else {
                System.out.println("No rows affected, check if the provided ID is correct.");
            }

            connection.close(); // Fechando a conexão
        } catch (Exception e) {
            System.out.println("fail in database connection postProfessor " + e.getMessage());
        }
    }

    public List<PostProfessor> buscarPostsPorMaterias(List<Integer> idMaterias) {
        List<PostProfessor> posts = new ArrayList<>();
        String SQL = "SELECT * FROM POST_PROFESSOR WHERE ID_Materia IN (" +
                String.join(",", Collections.nCopies(idMaterias.size(), "?")) +
                ") ORDER BY DATA DESC";

        try (Connection conn = ConnectionPoolConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            for (int i = 0; i < idMaterias.size(); i++) {
                stmt.setInt(i + 1, idMaterias.get(i));
            }
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PostProfessor post = new PostProfessor(
                            rs.getInt("ID_Post"),
                            rs.getString("Conteudo"),
                            rs.getDate("Data"),
                            rs.getInt("ID_Professor"),
                            rs.getInt("ID_Materia")
                    );
                    posts.add(post);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

}
