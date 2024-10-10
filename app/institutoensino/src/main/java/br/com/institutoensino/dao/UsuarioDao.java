package br.com.institutoensino.dao;

import br.com.institutoensino.config.ConnectionPoolConfig;
import br.com.institutoensino.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UsuarioDao {

    public void createUsuario(Usuario usuario) {
        String SQL = "INSERT INTO USUARIO (NOME, EMAIL, SENHA, NASCIMENTO, CPF, RG, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO, TELEFONE_COMERCIAL, CELULAR) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(SQL);
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
            con.close();
        } catch (Exception e) {
            System.out.println("fail in database connection usuario " + e.getMessage());
        }
    }

    public List<Usuario> findAllUsuarios() {
        String SQL = "SELECT * FROM USUARIO";

        try {
            Connection con = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Usuario> usuarios = new ArrayList<>();

            while (resultSet.next()) {
                String nome = resultSet.getString("NOME");
                String email = resultSet.getString("EMAIL");
                String senha = resultSet.getString("SENHA");
                Date nascimento = resultSet.getDate("NASCIMENTO");
                String cpf = resultSet.getString("CPF");
                String rg = resultSet.getString("RG");
                String logradouro = resultSet.getString("LOGRADOURO");
                int numero = resultSet.getInt("NUMERO");
                String complemento = resultSet.getString("COMPLEMENTO");
                String bairro = resultSet.getString("BAIRRO");
                String cidade = resultSet.getString("CIDADE");
                String estado = resultSet.getString("ESTADO");
                String telefoneComercial = resultSet.getString("TELEFONE_COMERCIAL");
                String celular = resultSet.getString("CELULAR");

                Usuario usuario = new Usuario(nome, email, senha, nascimento, cpf, rg, logradouro, numero, complemento, bairro, cidade, estado, telefoneComercial, celular);
                usuarios.add(usuario);
            }

            System.out.println("success in select * usuario");
            con.close();

            return usuarios;

        } catch (Exception e) {
            System.out.println("fail in database connection");

            return Collections.emptyList();
        }
    }
}
