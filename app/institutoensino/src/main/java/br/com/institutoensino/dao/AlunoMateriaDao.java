package br.com.institutoensino.dao;

import br.com.institutoensino.model.AlunoMateria;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlunoMateriaDao {

    public void createAlunoMateria(AlunoMateria alunoMateria) {
        String SQL = "INSERT INTO ALUNO_MATERIA (ID_ALUNO, ID_MATERIA, NOTA, FALTAS) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, alunoMateria.getIdAluno());
            preparedStatement.setInt(2, alunoMateria.getIdMateria());
            preparedStatement.setBigDecimal(3, alunoMateria.getNota());
            preparedStatement.setInt(4, alunoMateria.getFaltas());
            preparedStatement.execute();

            System.out.println("success in insert alunoMateria");
            connection.close();
        } catch (Exception e) {
            System.out.println("fail in database connection alunoMateria " + e.getMessage());
        }
    }

    public List<AlunoMateria> findAllAlunoMaterias() {
        String SQL = "SELECT * FROM ALUNO_MATERIA";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<AlunoMateria> alunoMaterias = new ArrayList<>();

            while (resultSet.next()) {
                int idAluno = resultSet.getInt("ID_ALUNO");
                int idMateria = resultSet.getInt("ID_MATERIA");
                BigDecimal nota = resultSet.getBigDecimal("NOTA");
                int faltas = resultSet.getInt("FALTAS");

                AlunoMateria alunoMateria = new AlunoMateria(idAluno, idMateria, nota, faltas);
                alunoMaterias.add(alunoMateria);
            }

            System.out.println("success in select * alunoMateria");
            connection.close();

            return alunoMaterias;

        } catch (Exception e) {
            System.out.println("fail in database connection");

            return Collections.emptyList();
        }
    }
}
