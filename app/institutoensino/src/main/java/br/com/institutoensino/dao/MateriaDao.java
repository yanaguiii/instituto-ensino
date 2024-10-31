package br.com.institutoensino.dao;

import br.com.institutoensino.config.ConnectionPoolConfig;
import br.com.institutoensino.model.Materia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MateriaDao {

    public void createMateria(Materia materia) {
        String SQL = "INSERT INTO MATERIA (NOME, ID_CURSO, ID_PROFESSOR) VALUES (?, ?, ?)";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();


            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, materia.getNomeMateria());
            preparedStatement.setInt(2, materia.getMateriaIdCurso());
            preparedStatement.setInt(3, materia.getMateriaIdProfessor());
            preparedStatement.execute();

            System.out.println("success in insert materia");
            connection.close();
        } catch (Exception e) {
            System.out.println("fail in database connection materia " + e.getMessage());
        }
    }

    public List<Materia> findAllMaterias() {
        String SQL = "SELECT * FROM MATERIA";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();


            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Materia> materias = new ArrayList<>();

            while (resultSet.next()) {
                int idMateria = resultSet.getInt("ID_MATERIA");
                String nome = resultSet.getString("NOME");
                int idCurso = resultSet.getInt("ID_CURSO");
                int idProfessor = resultSet.getInt("ID_PROFESSOR");

                Materia materia = new Materia(idMateria, nome, idCurso, idProfessor);
                materias.add(materia);
            }

            System.out.println("success in select * materia");
            connection.close();

            return materias;

        } catch (Exception e) {
            System.out.println("fail in database connection");

            return Collections.emptyList();
        }
    }

    public void deleteMateriaById(int idMateria) {
        String SQL = "DELETE FROM MATERIA WHERE ID_MATERIA = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idMateria);
            preparedStatement.execute();

            System.out.println("success in delete materia with id " + idMateria);
            connection.close();

        } catch (Exception e) {
            System.out.println("fail in database connection materia " + e.getMessage());
        }
    }
    public void updateMateria(Materia materia) {
        // String SQL para a atualização da matéria
        String SQL = "UPDATE MATERIA SET NOME = ?, ID_CURSO = ?, ID_PROFESSOR = ? WHERE ID_MATERIA = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            // Preparando o statement
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1, materia.getNomeMateria());
            preparedStatement.setObject(2, materia.getMateriaIdCurso());
            preparedStatement.setObject(3, materia.getMateriaIdProfessor());
            preparedStatement.setInt(4, materia.getIdMateria()); // Adicionando o ID da matéria para a cláusula WHERE

            // Executando a atualização
            int rowsAffected = preparedStatement.executeUpdate(); // Use executeUpdate para um UPDATE

            if (rowsAffected > 0) {
                System.out.println("success in update materia with id " + materia.getIdMateria());
            } else {
                System.out.println("No rows affected, check if the provided ID is correct.");
            }

            connection.close(); // Fechando a conexão
        } catch (Exception e) {
            System.out.println("fail in database connection materia " + e.getMessage());
        }
    }



}
