package br.com.institutoensino.dao;

import br.com.institutoensino.model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UsuarioDao {

    public void createUsuario(Usuario usuario) {
        String SQL = "INSERT INTO USUARIO (NOME, EMAIL, SENHA, NASCIMENTO, CPF, RG, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO, TELEFONE_COMERCIAL, CELULAR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setDate(4, new java.sql.Date(usuario.getNascimento().getTime()));
            preparedStatement.setString(5, usuario.getCpf());
            preparedStatement.setString(6, usuario.getRg());
            preparedStatement.setString(7, usuario.getLogradouro());
            preparedStatement.setInt(8, usuario.getNumero());
            preparedStatement.setString(9, usuario.getComplemento());
            preparedStatement.setString(10, usuario.getBairro());
            preparedStatement.setString(11, usuario.getCidade());
            preparedStatement.setString(12, usuario.getEstado());
            preparedStatement.setString(13, usuario.getTelefoneComercial());
            preparedStatement.setString(14, usuario.getCelular());
            preparedStatement.execute();

            System.out.println("success in insert usuario");
            connection.close();
        } catch (Exception e) {
            System.out.println("fail in database connection usuario " + e.getMessage());
        }
    }
}
