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

        String SQL = "INSERT INTO USUARIO (NOME, EMAIL, SENHA, NASCIMENTO, CPF, RG, LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO, TELEFONE_COMERCIAL, CELULAR, IS_ADMIN) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(SQL);
            preparedStatement.setString(1, usuario.getNomeUsuario());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setDate(4, (java.sql.Date) usuario.getNascimento());
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
            preparedStatement.setBoolean(15, usuario.isAdmin());
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
                boolean admin = resultSet.getBoolean("IS_ADMIN");

                Usuario usuario = new Usuario(idUsuario, nome, email, senha, nascimento, cpf, rg, logradouro, numero, complemento, bairro, cidade, estado, telefoneComercial, celular, admin);
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
                usuario.setNomeUsuario(rs.getString("Nome"));
                usuario.setEmail(rs.getString("Email"));
                usuario.setAdmin(rs.getBoolean("is_admin"));
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

        } catch (SQLException e) {
            System.out.println("Erro ao verificar e-mail: " + e.getMessage());
        }

        return existe;
    }

    public void deleteUsuarioById(int idUsuario) {
        String SQL = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, idUsuario);
            preparedStatement.execute();

            System.out.println("success in delete usuario with id " + idUsuario);
            connection.close();

        } catch (Exception e) {
            System.out.println("fail in database connection usuario " + e.getMessage());
        }
    }
    public void updateUsuario(Usuario usuario) {
        String SQL = "UPDATE USUARIO SET NOME = ?, EMAIL = ?, SENHA = ?, NASCIMENTO = ?, CPF = ?, RG = ?, " +
                "LOGRADOURO = ?, NUMERO = ?, COMPLEMENTO = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?, " +
                "TELEFONE_COMERCIAL = ?, CELULAR = ? WHERE ID_USUARIO = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();


            // Preparando o statement
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            // Definindo os parâmetros, garantindo que os campos sejam válidos
            preparedStatement.setObject(1, usuario.getNomeUsuario() != null && !usuario.getNomeUsuario().isEmpty() ? usuario.getNomeUsuario() : null);
            preparedStatement.setObject(2, usuario.getEmail() != null && !usuario.getEmail().isEmpty() ? usuario.getEmail() : null);
            preparedStatement.setObject(3, usuario.getSenha() != null && !usuario.getSenha().isEmpty() ? usuario.getSenha() : null);
            preparedStatement.setObject(4, usuario.getNascimento() != null ? new java.sql.Date(usuario.getNascimento().getTime()) : null);
            preparedStatement.setObject(5, usuario.getCpf() != null && !usuario.getCpf().isEmpty() ? usuario.getCpf() : null);
            preparedStatement.setObject(6, usuario.getRg() != null && !usuario.getRg().isEmpty() ? usuario.getRg() : null);
            preparedStatement.setObject(7, usuario.getLogradouro() != null && !usuario.getLogradouro().isEmpty() ? usuario.getLogradouro() : null);
            preparedStatement.setObject(8, usuario.getNumero() > 0 ? usuario.getNumero() : null);
            preparedStatement.setObject(9, usuario.getComplemento() != null && !usuario.getComplemento().isEmpty() ? usuario.getComplemento() : null);
            preparedStatement.setObject(10, usuario.getBairro() != null && !usuario.getBairro().isEmpty() ? usuario.getBairro() : null);
            preparedStatement.setObject(11, usuario.getCidade() != null && !usuario.getCidade().isEmpty() ? usuario.getCidade() : null);
            preparedStatement.setObject(12, usuario.getEstado() != null && !usuario.getEstado().isEmpty() ? usuario.getEstado() : null);
            preparedStatement.setObject(13, usuario.getTelefoneComercial() != null && !usuario.getTelefoneComercial().isEmpty() ? usuario.getTelefoneComercial() : null);
            preparedStatement.setObject(14, usuario.getCelular() != null && !usuario.getCelular().isEmpty() ? usuario.getCelular() : null);
            preparedStatement.setInt(15, usuario.getIdUsuario()); // ID do usuário para a cláusula WHERE

            // Executando a atualização
            int rowsAffected = preparedStatement.executeUpdate(); // Use executeUpdate para um UPDATE

            if (rowsAffected > 0) {
                System.out.println("success in update usuario with id " + usuario.getIdUsuario());
            } else {
                System.out.println("No rows affected, check if the provided ID is correct.");
            }

            connection.close(); // Fechando a conexão
        } catch (Exception e) {
            System.out.println("fail in database connection usuario " + e.getMessage());
        }
    }


    public Usuario findUserByEmail(String email) {
        String sql = "SELECT * FROM USUARIO WHERE email = ?";
        try (Connection conn = ConnectionPoolConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            System.out.println("Tentando achar email " + email);
            stmt.setString(1, email);  // Define o parâmetro do email na consulta.

            try (ResultSet rs = stmt.executeQuery()) {  // Usamos try-with-resources para ResultSet.
                if (rs.next()) {
                    System.out.println("Achou");
                    // Se encontrar um usuário, cria o objeto.
                    return new Usuario(
                            rs.getInt("ID_USUARIO"),
                            rs.getString("NOME"),
                            rs.getString("EMAIL"),
                            rs.getString("SENHA"),
                            rs.getDate("NASCIMENTO"),
                            rs.getString("CPF"),
                            rs.getString("RG"),
                            rs.getString("LOGRADOURO"),
                            rs.getInt("NUMERO"),
                            rs.getString("COMPLEMENTO"),
                            rs.getString("BAIRRO"),
                            rs.getString("CIDADE"),
                            rs.getString("ESTADO"),
                            rs.getString("TELEFONE_COMERCIAL"),
                            rs.getString("CELULAR")
                    );
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean existsAdmin() {
        String SQL = "SELECT COUNT(*) FROM USUARIO WHERE Is_Admin = TRUE";
        try (Connection conn = ConnectionPoolConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public String verificarTipoUsuario(int idUsuario) {
        String SQL = "SELECT " +
                "CASE " +
                "  WHEN a.ID_Aluno IS NOT NULL THEN 'ALUNO' " +
                "  WHEN p.ID_Professor IS NOT NULL THEN 'PROFESSOR' " +
                "  ELSE 'USUARIO' " +
                "END AS tipo " +
                "FROM USUARIO u " +
                "LEFT JOIN ALUNO a ON u.ID_Usuario = a.ID_Usuario " +
                "LEFT JOIN PROFESSOR p ON u.ID_Usuario = p.ID_Usuario " +
                "WHERE u.ID_Usuario = ?";

        try (Connection conn = ConnectionPoolConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setInt(1, idUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("tipo");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "DESCONHECIDO";
    }

    public Usuario findUserById(int idUsuario) {
        Usuario usuario = null;

        try (Connection connection = ConnectionPoolConfig.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Usuario WHERE id_Usuario = ?")) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Achou");
                // Se encontrar um usuário, cria o objeto.
                return new Usuario(
                        rs.getInt("ID_USUARIO"),
                        rs.getString("NOME"),
                        rs.getString("EMAIL"),
                        rs.getString("SENHA"),
                        rs.getDate("NASCIMENTO"),
                        rs.getString("CPF"),
                        rs.getString("RG"),
                        rs.getString("LOGRADOURO"),
                        rs.getInt("NUMERO"),
                        rs.getString("COMPLEMENTO"),
                        rs.getString("BAIRRO"),
                        rs.getString("CIDADE"),
                        rs.getString("ESTADO"),
                        rs.getString("TELEFONE_COMERCIAL"),
                        rs.getString("CELULAR")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }


    public Integer getIdAlunoByIdUsuario(int idUsuario) {
        String SQL = "SELECT ID_ALUNO FROM ALUNO WHERE ID_USUARIO = ?";
        try (Connection conn = ConnectionPoolConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("ID_ALUNO");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Caso não encontre o ID_ALUNO
    }

    public Integer getIdProfessorByIdUsuario(int idUsuario) {
        String SQL = "SELECT ID_PROFESSOR FROM PROFESSOR WHERE ID_USUARIO = ?";
        try (Connection conn = ConnectionPoolConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("ID_PROFESSOR");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Caso não encontre o ID_PROFESSOR
    }

}


