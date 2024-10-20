package br.com.institutoensino.model;

import java.math.BigDecimal;

public class Professor {
    private int idProfessor;
    private int idUsuario;
    private BigDecimal salario;

    public Professor() {}

    public Professor(int idProfessor, int idUsuario, BigDecimal salario) {
        this.idProfessor = idProfessor;
        this.idUsuario = idUsuario;
        this.salario = salario;
    }

    public Professor(int idUsuario, BigDecimal salario) {
        this.idUsuario = idUsuario;
        this.salario = salario;
    }


    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
