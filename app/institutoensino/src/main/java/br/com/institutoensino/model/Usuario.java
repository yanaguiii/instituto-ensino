package br.com.institutoensino.model;

import java.util.Date;

public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String email;
    private String senha;
    private Date nascimento;
    private String cpf;
    private String rg;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefoneComercial;
    private String celular;
    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Usuario() {
    }

    public Usuario(int idUsuario, String nomeUsuario, String email, String senha, Date nascimento, String cpf, String rg,
                   String logradouro, int numero, String complemento, String bairro, String cidade,
                   String estado, String telefoneComercial, String celular) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefoneComercial = telefoneComercial;
        this.celular = celular;
    }

    public Usuario(int idUsuario, String nomeUsuario, String email, String senha, Date nascimento, String cpf, String rg,
                   String logradouro, int numero, String complemento, String bairro, String cidade,
                   String estado, String telefoneComercial, String celular, boolean isAdmin) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefoneComercial = telefoneComercial;
        this.celular = celular;
        this.isAdmin = isAdmin;
    }

    public Usuario(String nomeUsuario, String email, String senha, Date nascimento, String cpf, String rg,
                   String logradouro, int numero, String complemento, String bairro, String cidade,
                   String estado, String telefoneComercial, String celular) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefoneComercial = telefoneComercial;
        this.celular = celular;
    }

    public Usuario(String nomeUsuario, String email, String senha, Date nascimento, String cpf, String rg,
                   String logradouro, int numero, String complemento, String bairro, String cidade,
                   String estado, String telefoneComercial, String celular, boolean isAdmin) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefoneComercial = telefoneComercial;
        this.celular = celular;
        this.isAdmin = isAdmin;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
