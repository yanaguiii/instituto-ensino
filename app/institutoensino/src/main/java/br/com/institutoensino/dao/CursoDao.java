package br.com.institutoensino.dao;

import br.com.institutoensino.config.ConnectionPoolConfig;
import br.com.institutoensino.model.Curso;
import br.com.institutoensino.model.Materia;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CursoDao {

    public void createCurso(Curso curso) {
        String SQL = "INSERT INTO CURSO (NOME, MODALIDADE, DURACAO, CAMPUS, TURNO, DESCRICAO) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {

            connection = ConnectionPoolConfig.getConnection();


            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, curso.getNomeCurso());
            preparedStatement.setString(2, curso.getModalidade());
            preparedStatement.setFloat(3, curso.getDuracao());
            preparedStatement.setString(4, curso.getCampus());
            preparedStatement.setString(5, curso.getTurno());
            preparedStatement.setString(6, curso.getDescricao());
            preparedStatement.execute();

            System.out.println("success in insert curso");
            preparedStatement.close();

        } catch (Exception e) {

            System.out.println("fail in database connection curso " + e.getMessage());

        }
    }

    public List<Curso> findAllCursos() {

        String SQL = "SELECT * FROM CURSO";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();


            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Curso> cursos = new ArrayList<>();

            while (resultSet.next()) {
                int idCurso = resultSet.getInt("ID_CURSO");
                String cursoNome = resultSet.getString("NOME");
                String cursoModalidade = resultSet.getString("MODALIDADE");
                float cursoDuracao = resultSet.getFloat("DURACAO");
                String cursoCampus = resultSet.getString("CAMPUS");
                String cursoTurno = resultSet.getString("TURNO");
                String cursoDescricao = resultSet.getString("DESCRICAO");


                Curso curso = new Curso(idCurso, cursoNome, cursoModalidade, cursoDuracao, cursoCampus, cursoTurno, cursoDescricao);
                cursos.add(curso);
            }


            System.out.println("success in select * curso");

            connection.close();

            return cursos;

        } catch (Exception e) {

            System.out.println("fail in database connection");

            return Collections.emptyList();

        }

    }

    public void deleteCursoById(int idCurso) {
        String SQL = "DELETE FROM CURSO WHERE ID_CURSO = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();


            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idCurso);
            preparedStatement.execute();

            System.out.println("success in delete curso with id " + idCurso);
            connection.close();

        } catch (Exception e) {
            System.out.println("fail in database connection curso " + e.getMessage());
        }
    }

    public void updateCurso(Curso curso) {
        // String SQL para a atualização do curso
        String SQL = "UPDATE CURSO SET NOME = ?, MODALIDADE = ?, DURACAO = ?, CAMPUS = ?, TURNO = ?, DESCRICAO = ? WHERE ID_CURSO = ?";

        PreparedStatement preparedStatement = null;

        try {
            // Conexão ao banco de dados
            Connection connection = ConnectionPoolConfig.getConnection();


            // Preparando o statement
            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, curso.getNomeCurso());
            preparedStatement.setString(2, curso.getModalidade());
            preparedStatement.setFloat(3, curso.getDuracao());
            preparedStatement.setString(4, curso.getCampus());
            preparedStatement.setString(5, curso.getTurno());
            preparedStatement.setString(6, curso.getDescricao());
            preparedStatement.setInt(7, curso.getIdCurso());
            preparedStatement.execute();

            // Executando a atualização
            int rowsAffected = preparedStatement.executeUpdate(); // Use executeUpdate para um UPDATE

            if (rowsAffected > 0) {
                System.out.println("success in update curso with id " + curso.getIdCurso());
            } else {
                System.out.println("No rows affected, check if the provided ID is correct.");
            }

            connection.close(); // Fechando a conexão
        } catch (Exception e) {
            System.out.println("fail in database connection curso " + e.getMessage());
        }
    }

    public Curso getCursoById(int idCurso) {
        String SQL = "SELECT * FROM CURSO WHERE ID_CURSO = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setInt(1, idCurso);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String cursoNome = resultSet.getString("NOME");
                    String cursoModalidade = resultSet.getString("MODALIDADE");
                    float cursoDuracao = resultSet.getFloat("DURACAO");
                    String cursoCampus = resultSet.getString("CAMPUS");
                    String cursoTurno = resultSet.getString("TURNO");
                    String cursoDescricao = resultSet.getString("DESCRICAO");

                    Curso curso = new Curso(idCurso, cursoNome, cursoModalidade, cursoDuracao, cursoCampus, cursoTurno, cursoDescricao);

                    System.out.println("Success in select curso: " + cursoNome);

                    return curso;
                } else {
                    System.out.println("No curso found with ID: " + idCurso);
                    return null;
                }
            }
        } catch (SQLException e) {
            System.out.println("Fail in database connection: " + e.getMessage());
            return null;
        }
    }

    public Curso getCursoByNome(String nome) {
        String SQL = "SELECT * FROM CURSO WHERE NOME = ?";

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)) {

            preparedStatement.setString(1, nome);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int idCurso = resultSet.getInt("ID_CURSO");
                    String cursoNome = resultSet.getString("NOME");
                    String cursoModalidade = resultSet.getString("MODALIDADE");
                    float cursoDuracao = resultSet.getFloat("DURACAO");
                    String cursoCampus = resultSet.getString("CAMPUS");
                    String cursoTurno = resultSet.getString("TURNO");
                    String cursoDescricao = resultSet.getString("DESCRICAO");

                    Curso curso = new Curso(idCurso, cursoNome, cursoModalidade, cursoDuracao, cursoCampus, cursoTurno, cursoDescricao);

                    System.out.println("Success in selecting curso: " + cursoNome);

                    return curso;
                } else {
                    System.out.println("No curso found with name: " + nome);
                    return null;
                }
            }
        } catch (SQLException e) {
            System.out.println("Fail in database connection: " + e.getMessage());
            return null;
        }
    }

    public List<Materia> getMateriasPorCurso(int idCurso) {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM MATERIA WHERE ID_CURSO = ?";

        try (Connection conn = ConnectionPoolConfig.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCurso);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("ID_MATERIA"));
                materia.setNomeMateria(rs.getString("NOME"));
                materia.setMateriaIdCurso(rs.getInt("ID_CURSO"));
                materia.setMateriaIdProfessor(rs.getInt("ID_PROFESSOR"));
                materias.add(materia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return materias;
    }

}
