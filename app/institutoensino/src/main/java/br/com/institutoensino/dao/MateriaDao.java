package br.com.institutoensino.dao;

import br.com.institutoensino.model.Materia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MateriaDao {

    public void createMateria(Materia materia) {
        String SQL = "INSERT INTO MATERIA (NOME, ID_CURSO, ID_PROFESSOR) VALUES (?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, materia.getNome());
            preparedStatement.setInt(2, materia.getIdCurso());
            preparedStatement.setInt(3, materia.getIdProfessor());
            preparedStatement.execute();

            System.out.println("success in insert materia");
            connection.close();
        } catch (Exception e) {
            System.out.println("fail in database connection materia " + e.getMessage());
        }
    }
}
