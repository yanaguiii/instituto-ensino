package br.com.institutoensino.dao;

import br.com.institutoensino.config.ConnectionPoolConfig;
import br.com.institutoensino.model.Aluno;
import br.com.institutoensino.model.Materia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AlunoDao {

    public void createAluno(Aluno aluno) {
        String SQL = "INSERT INTO ALUNO (ID_USUARIO, ID_CURSO) VALUES (?, ?)";
        try (Connection con = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(SQL)) {
            preparedStatement.setInt(1, aluno.getAlunoIdUsuario());
            preparedStatement.setInt(2, aluno.getAlunoIdCurso());
            preparedStatement.execute();
            System.out.println("Aluno inserido com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir aluno: " + e.getMessage());
        }
    }


    public List<Aluno> findAllAlunos() {

        String SQL = "SELECT * FROM ALUNO";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Aluno> alunos = new ArrayList<>();

            while (resultSet.next()) {
                int idAluno = resultSet.getInt("ID_ALUNO");
                int idUsuario = resultSet.getInt("ID_USUARIO");
                int idCurso = resultSet.getInt("ID_CURSO");


                Aluno aluno = new Aluno(idAluno, idUsuario, idCurso);
                alunos.add(aluno);
            }


            System.out.println("success in select * aluno");

            connection.close();

            return alunos;

        } catch (Exception e) {

            System.out.println("fail in database connection aluno");

            return Collections.emptyList();

        }

    }

    public void deleteAlunoById(int idAluno) {
        String SQL = "DELETE FROM ALUNO WHERE ID_ALUNO = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();


            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idAluno);
            preparedStatement.execute();

            System.out.println("success in delete aluno with id " + idAluno);
            connection.close();

        } catch (Exception e) {
            System.out.println("fail in database connection aluno " + e.getMessage());
        }
    }

    public Integer getIdAlunoByIdUsuario(int idUsuario) {
        String sql = "SELECT ID_ALUNO FROM ALUNO WHERE ID_USUARIO = ?";
        Integer idAluno = null;

        try (Connection conn = ConnectionPoolConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    idAluno = rs.getInt("ID_ALUNO");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idAluno; // Pode retornar null se não encontrar o ID_ALUNO
    }


    public void updateAluno(Aluno aluno) {
        // String SQL para a atualização do aluno
        String SQL = "UPDATE ALUNO SET ID_USUARIO = ?, ID_CURSO = ? WHERE ID_ALUNO = ?";

        try {
            // Estabelecendo a conexão
            Connection connection = ConnectionPoolConfig.getConnection();

            // Preparando o statement
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, aluno.getAlunoIdUsuario());
            preparedStatement.setInt(2, aluno.getAlunoIdCurso());
            preparedStatement.setInt(3, aluno.getIdAluno()); // Adicionando o ID do aluno para a cláusula WHERE

            // Executando a atualização
            int rowsAffected = preparedStatement.executeUpdate(); // Use executeUpdate para um UPDATE

            if (rowsAffected > 0) {
                System.out.println("Success in update aluno with id " + aluno.getIdAluno());
            } else {
                System.out.println("No rows affected, check if the provided ID is correct.");
            }

            // Fechando a conexão
            connection.close();
        } catch (SQLException e) {
            System.out.println("Fail in database connection aluno " + e.getMessage());
        }
    }

    public Aluno findAlunoById(int idAluno) {
        String SQL = "SELECT * FROM ALUNO WHERE ID_ALUNO = ?";
        try (Connection conn = ConnectionPoolConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setInt(1, idAluno);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int idUsuario = rs.getInt("ID_USUARIO");
                    int idCurso = rs.getInt("ID_CURSO");

                    return new Aluno(idAluno, idUsuario, idCurso);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Map<String, Object>> buscarMateriasDoAluno(int idUsuario) {
        List<Map<String, Object>> materiaInfos = new ArrayList<>();
        String SQL = "SELECT m.ID_Materia, m.Nome, am.Faltas, am.Nota " +
                "FROM MATERIA m " +
                "JOIN ALUNO_MATERIA am ON m.ID_Materia = am.ID_Materia " +
                "JOIN ALUNO a ON am.ID_Aluno = a.ID_Aluno " +
                "WHERE a.ID_Usuario = ?";

        try (Connection conn = ConnectionPoolConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setInt(1, idUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Map<String, Object> materiaInfo = new HashMap<>();
                    materiaInfo.put("idMateria", rs.getInt("ID_Materia"));
                    materiaInfo.put("nomeMateria", rs.getString("Nome"));
                    materiaInfo.put("faltas", rs.getInt("Faltas"));
                    materiaInfo.put("nota", rs.getBigDecimal("Nota"));
                    materiaInfos.add(materiaInfo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materiaInfos;
    }

    public List<Integer> buscarIdMateriasPorAluno(int idAluno) {
        List<Integer> idMaterias = new ArrayList<>();
        String SQL = "SELECT ID_Materia FROM ALUNO_MATERIA WHERE ID_Aluno = ?";

        try (Connection conn = ConnectionPoolConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setInt(1, idAluno);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    idMaterias.add(rs.getInt("ID_Materia"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idMaterias;
    }
}


