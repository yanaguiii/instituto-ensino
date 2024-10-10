package br.com.institutoensino.dao;

import br.com.institutoensino.model.Materia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<Materia> findAllMaterias() {
        String SQL = "SELECT * FROM MATERIA";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Materia> materias = new ArrayList<>();

            while (resultSet.next()) {
                String nome = resultSet.getString("NOME");
                int idCurso = resultSet.getInt("ID_CURSO");
                int idProfessor = resultSet.getInt("ID_PROFESSOR");

                Materia materia = new Materia(nome, idCurso, idProfessor);
                materias.add(materia);
            }

            System.out.println("success in select * materia");
            connection.close();

            return materias;

        } catch (Exception e) {
            System.out.println("fail in database connection");

            return Collections.emptyList();
        }
    }
}
