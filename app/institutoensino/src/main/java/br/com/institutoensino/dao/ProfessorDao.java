package br.com.institutoensino.dao;

import br.com.institutoensino.model.Professor;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<Professor> findAllProfessores() {
        String SQL = "SELECT * FROM PROFESSOR";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Professor> professores = new ArrayList<>();

            while (resultSet.next()) {
                int idUsuario = resultSet.getInt("ID_USUARIO");
                BigDecimal salario = resultSet.getBigDecimal("SALARIO");

                Professor professor = new Professor(idUsuario, salario);
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
}
