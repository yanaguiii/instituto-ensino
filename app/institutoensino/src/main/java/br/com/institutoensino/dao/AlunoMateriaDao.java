package br.com.institutoensino.dao;

import br.com.institutoensino.config.ConnectionPoolConfig;
import br.com.institutoensino.model.AlunoMateria;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlunoMateriaDao {

    public void createAlunoMateria(AlunoMateria alunoMateria) {
        String SQL = "INSERT INTO ALUNO_MATERIA (ID_ALUNO, ID_MATERIA, NOTA, FALTAS) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();


            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, alunoMateria.getAlunoMateriaIdAluno());
            preparedStatement.setInt(2, alunoMateria.getAlunoMateriaIdMateria());
            preparedStatement.setBigDecimal(3, alunoMateria.getNota());
            preparedStatement.setInt(4, alunoMateria.getFaltas());
            preparedStatement.execute();

            System.out.println("success in insert alunoMateria");
            connection.close();
        } catch (Exception e) {
            System.out.println("fail in database connection alunoMateria " + e.getMessage());
        }
    }

    public List<AlunoMateria> findAllAlunoMaterias() {
        String SQL = "SELECT * FROM ALUNO_MATERIA";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();


            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<AlunoMateria> alunoMaterias = new ArrayList<>();

            while (resultSet.next()) {
                int idAluno = resultSet.getInt("ID_ALUNO");
                int idMateria = resultSet.getInt("ID_MATERIA");
                BigDecimal nota = resultSet.getBigDecimal("NOTA");
                int faltas = resultSet.getInt("FALTAS");

                AlunoMateria alunoMateria = new AlunoMateria(idAluno, idMateria, nota, faltas);
                alunoMaterias.add(alunoMateria);
            }

            System.out.println("success in select * alunoMateria");
            connection.close();

            return alunoMaterias;

        } catch (Exception e) {
            System.out.println("fail in database connection");

            return Collections.emptyList();
        }
    }

    public void deleteAlunoMateriaById(int idAluno, int idMateria) {
        String SQL = "DELETE FROM ALUNO_MATERIA WHERE ID_ALUNO = ? AND ID_MATERIA = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();


            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idAluno);
            preparedStatement.setInt(2, idMateria);
            preparedStatement.execute();

            System.out.println("success in delete alunoMateria with idAluno " + idAluno + " and idMateria " + idMateria);
            connection.close();

        } catch (Exception e) {
            System.out.println("fail in database connection alunoMateria " + e.getMessage());
        }
    }

    public void updateAlunoMateria(AlunoMateria alunoMateria) {
        String SQL = "UPDATE ALUNO_MATERIA SET NOTA = ?, FALTAS = ? WHERE ID_ALUNO = ? AND ID_MATERIA = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();


            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1, alunoMateria.getNota());
            preparedStatement.setObject(2, alunoMateria.getFaltas());
            preparedStatement.setInt(3, alunoMateria.getAlunoMateriaIdAluno());
            preparedStatement.setInt(4, alunoMateria.getAlunoMateriaIdMateria());

            int rowsAffected = preparedStatement.executeUpdate(); // Use executeUpdate para um UPDATE

            if (rowsAffected > 0) {
                System.out.println("success in update alunoMateria with idAluno " + alunoMateria.getAlunoMateriaIdAluno() + " and idMateria " + alunoMateria.getAlunoMateriaIdMateria());
            } else {
                System.out.println("No rows affected, check if the provided IDs are correct.");
            }

            connection.close();
        } catch (Exception e) {
            System.out.println("fail in database connection alunoMateria " + e.getMessage());
        }
    }

    public boolean existsByIds(int idAluno, int idMateria) {
        String SQL = "SELECT COUNT(*) FROM ALUNO_MATERIA WHERE ID_ALUNO = ? AND ID_MATERIA = ?";

        // Use o ConnectionPoolConfig para obter a conexão
        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {
            preparedStatement.setInt(1, idAluno);
            preparedStatement.setInt(2, idMateria);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (Exception e) {
            System.out.println("Falha na conexão com o banco de dados em existsByIds: " + e.getMessage());
        }
        return false;
    }


}
