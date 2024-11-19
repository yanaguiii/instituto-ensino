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
        String SQL = "INSERT INTO ALUNO (ID_USUARIO) VALUES (?)";
        try (Connection con = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(SQL)) {
            preparedStatement.setInt(1, aluno.getAlunoIdUsuario());
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


                Aluno aluno = new Aluno(idAluno, idUsuario);
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
}


