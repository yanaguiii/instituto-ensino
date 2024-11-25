package br.com.institutoensino.dao;

import br.com.institutoensino.config.ConnectionPoolConfig;
import br.com.institutoensino.model.Professor;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

public class ProfessorDao {

    public void createProfessor(Professor professor) {
        String SQL = "INSERT INTO PROFESSOR (ID_USUARIO, SALARIO) VALUES (?, ?)";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();


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
            Connection connection = ConnectionPoolConfig.getConnection();


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
            Connection connection = ConnectionPoolConfig.getConnection();


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
            Connection connection = ConnectionPoolConfig.getConnection();


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

    public Integer getIdProfessorByIdUsuario(int idUsuario) {
        String SQL = "SELECT ID_Professor FROM PROFESSOR WHERE ID_Usuario = ?";
        Integer idProfessor = null;

        try (Connection conn = ConnectionPoolConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    idProfessor = rs.getInt("ID_Professor");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idProfessor;
    }


    public List<Map<String, Object>> getMateriasByIdProfessor(int idProfessor) {
        List<Map<String, Object>> materias = new ArrayList<>();
        String SQL = "SELECT m.ID_Materia, m.Nome, a.Nome AS NomeAluno, am.Faltas, am.Nota, al.ID_Aluno " +
                "FROM MATERIA m " +
                "JOIN ALUNO_MATERIA am ON m.ID_Materia = am.ID_Materia " +
                "JOIN ALUNO al ON am.ID_Aluno = al.ID_Aluno " +
                "JOIN USUARIO a ON al.ID_Usuario = a.ID_Usuario " +
                "WHERE m.ID_Professor = ?";

        try (Connection conn = ConnectionPoolConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, idProfessor);
            try (ResultSet rs = stmt.executeQuery()) {
                Map<Integer, Map<String, Object>> materiaMap = new HashMap<>();
                while (rs.next()) {
                    int idMateria = rs.getInt("ID_Materia");
                    Map<String, Object> materia = materiaMap.computeIfAbsent(idMateria, k -> {
                        Map<String, Object> m = new HashMap<>();
                        m.put("idMateria", idMateria);
                        try {
                            m.put("nomeMateria", rs.getString("Nome"));
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        m.put("alunos", new ArrayList<Map<String, Object>>());
                        return m;
                    });

                    Map<String, Object> aluno = new HashMap<>();
                    aluno.put("idAluno", rs.getInt("ID_Aluno"));
                    aluno.put("nomeAluno", rs.getString("NomeAluno"));
                    aluno.put("faltas", rs.getInt("Faltas"));
                    aluno.put("nota", rs.getBigDecimal("Nota"));
                    ((List<Map<String, Object>>) materia.get("alunos")).add(aluno);
                }
                System.out.println("Executando query para idProfessor: " + idProfessor);
                System.out.println("Número de matérias encontradas: " + materiaMap.size());

                materias.addAll(materiaMap.values());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materias;
    }

}
