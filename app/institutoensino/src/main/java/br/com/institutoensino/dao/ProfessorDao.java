package br.com.institutoensino.dao;

import br.com.institutoensino.model.Professor;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProfessorDao {

    public void createProfessor(Professor professor) {
        String SQL = "INSERT INTO PROFESSOR (ID_USUARIO, SALARIO) VALUES (?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, professor.getProfessorIdUsuario());
            preparedStatement.setDouble(2, professor.getSalario());
            preparedStatement.execute();

            System.out.println("success in insert professor");
            connection.close();
        } catch (Exception e) {
            System.out.println("fail in database connection professor " + e.getMessage());
        }
    }

    public List<Professor> findAllProfessores() {
        String SQL = "SELECT * FROM PROFESSOR";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Professor> professores = new ArrayList<>();

            while (resultSet.next()) {
                int idProfessor = resultSet.getInt("ID_PROFESSOR");
                int idUsuario = resultSet.getInt("ID_USUARIO");
                double salario = resultSet.getDouble("SALARIO");

                Professor professor = new Professor(idProfessor, idUsuario, salario);
                professores.add(professor);
            }

            System.out.println("success in select * professor");
            connection.close();

            return professores;

        } catch (Exception e) {
            System.out.println("fail in database connection");

            return Collections.emptyList();
        }
    }

    public void deleteProfessorById(int idProfessor) {
        String SQL = "DELETE FROM PROFESSOR WHERE ID_PROFESSOR = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idProfessor);
            preparedStatement.execute();

            System.out.println("success in delete professor with id " + idProfessor);
            connection.close();

        } catch (Exception e) {
            System.out.println("fail in database connection professor " + e.getMessage());
        }
    }

    public void updateProfessor(Professor professor) {
        // String SQL para a atualização do professor
        String SQL = "UPDATE PROFESSOR SET ID_USUARIO = ?, SALARIO = ? WHERE ID_PROFESSOR = ?";

        try {
            // Conexão ao banco de dados
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            // Preparando o statement
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1, professor.getProfessorIdUsuario() > 0 ? professor.getProfessorIdUsuario() : null);
            preparedStatement.setObject(2, professor.getSalario() != 0 ? professor.getSalario() : null);
            preparedStatement.setInt(3, professor.getIdProfessor()); // Adicionando o ID do professor para a cláusula WHERE

            // Executando a atualização
            int rowsAffected = preparedStatement.executeUpdate(); // Use executeUpdate para um UPDATE

            if (rowsAffected > 0) {
                System.out.println("success in update professor with id " + professor.getIdProfessor());
            } else {
                System.out.println("No rows affected, check if the provided ID is correct.");
            }

            connection.close(); // Fechando a conexão
        } catch (Exception e) {
            System.out.println("fail in database connection professor " + e.getMessage());
        }
    }



}
