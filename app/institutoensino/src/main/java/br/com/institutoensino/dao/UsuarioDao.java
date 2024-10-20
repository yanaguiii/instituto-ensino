package br.com.institutoensino.dao;

import br.com.institutoensino.config.ConnectionPoolConfig;
import br.com.institutoensino.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UsuarioDao {

    public void createUsuario(Usuario usuario) {
        if (emailExiste(usuario.getEmail())) {
            System.out.println("O e-mail já está cadastrado.");
            return;
        }

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

            System.out.println("Usuário inserido com sucesso.");
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
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
                int idUsuario = resultSet.getInt("ID_USUARIO");
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

                Usuario usuario = new Usuario(idUsuario, nome, email, senha, nascimento, cpf, rg, logradouro, numero, complemento, bairro, cidade, estado, telefoneComercial, celular);
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


        public Usuario validarLogin(String email, String password) {
            Usuario usuario = null;
            try (Connection conn = ConnectionPoolConfig.getConnection()) {
                String SQL = "SELECT * FROM USUARIO WHERE Email = ? AND Senha = ?";
                PreparedStatement stmt = conn.prepareStatement(SQL);
                stmt.setString(1, email);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("ID_Usuario"));
                    usuario.setNome(rs.getString("Nome"));
                    usuario.setEmail(rs.getString("Email"));
                    // Pegar outros campos se necessário
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return usuario;
        }

    public boolean emailExiste(String email) {
        String SQL = "SELECT COUNT(*) FROM USUARIO WHERE EMAIL = ?";
        boolean existe = false;

        try (Connection con = ConnectionPoolConfig.getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement(SQL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                existe = count > 0;  // Se o resultado for maior que 0, o email já existe
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao verificar e-mail: " + e.getMessage());
        }

        return existe;
    }

    public void deleteUsuarioById(int idUsuario) {
        String SQL = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idUsuario);
            preparedStatement.execute();

            System.out.println("success in delete usuario with id " + idUsuario);
            connection.close();

        } catch (Exception e) {
            System.out.println("fail in database connection usuario " + e.getMessage());
        }
    }


}


