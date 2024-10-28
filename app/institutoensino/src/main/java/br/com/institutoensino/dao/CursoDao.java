package br.com.institutoensino.dao;

import br.com.institutoensino.model.Aluno;
import br.com.institutoensino.model.Curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CursoDao {

    public void createCurso(Curso curso) {
        String SQL = "INSERT INTO CURSO (NOME, MODALIDADE, DURACAO, CAMPUS, TURNO, DESCRICAO) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {

            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, curso.getNome());
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

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

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
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

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

        try {
            // Conexão ao banco de dados
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            // Preparando o statement
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setObject(1, curso.getNome());
            preparedStatement.setObject(2, curso.getModalidade());
            preparedStatement.setObject(3, curso.getDuracao());
            preparedStatement.setObject(4, curso.getCampus());
            preparedStatement.setObject(5, curso.getTurno());
            preparedStatement.setObject(6, curso.getDescricao());
            preparedStatement.setInt(7, curso.getIdCurso()); // Adicionando o ID do curso para a cláusula WHERE

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



}
