package br.com.institutoensino.dao;

import br.com.institutoensino.model.Aluno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
}
