package br.com.institutoensino.dao;

import br.com.institutoensino.model.Professor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProfessorDao {

    public void createProfessor(Professor professor) {
        String SQL = "INSERT INTO PROFESSOR (ID_USUARIO, SALARIO) VALUES (?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, professor.getIdUsuario());
            preparedStatement.setBigDecimal(2, professor.getSalario());
            preparedStatement.execute();

            System.out.println("success in insert professor");
            connection.close();
        } catch (Exception e) {
            System.out.println("fail in database connection professor " + e.getMessage());
        }
    }
}
