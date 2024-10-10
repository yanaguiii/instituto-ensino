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

public class AlunoDao {

    public void createAluno(Aluno aluno) {
        String SQL = "INSERT INTO ALUNO (ID_USUARIO, MATRICULA) VALUES (?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, aluno.getIdUsuario());
            preparedStatement.setString(2, aluno.getMatricula());
            preparedStatement.execute();

            System.out.println("success in insert aluno");
            connection.close();
        } catch (Exception e) {
            System.out.println("fail in database connection aluno " + e.getMessage());
        }
    }

    public List<Aluno> findAllAlunos() {

        String SQL = "SELECT * FROM ALUNO";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Aluno> alunos = new ArrayList<>();

            while (resultSet.next()) {
                String idUsuarioStr = resultSet.getString("ID_USUARIO"); // Ajuste aqui
                String matricula = resultSet.getString("MATRICULA");

                int idUsuario = Integer.parseInt(idUsuarioStr);

                Aluno aluno = new Aluno(idUsuario, matricula);
                alunos.add(aluno);
            }


            System.out.println("success in select * curso");

            connection.close();

            return alunos;

        } catch (Exception e) {

            System.out.println("fail in database connection");

            return Collections.emptyList();

        }

    }
}

