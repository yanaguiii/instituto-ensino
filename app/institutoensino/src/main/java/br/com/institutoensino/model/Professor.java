package br.com.institutoensino.model;

import java.math.BigDecimal;

public class Professor {
    private int idProfessor;
    private int professorIdUsuario;
    private double salario;

    public Professor() {
    }

    public Professor(int idProfessor, int professorIdUsuario, double salario) {
        this.idProfessor = idProfessor;
        this.professorIdUsuario = professorIdUsuario;
        this.salario = salario;
    }

    public Professor(int professorIdUsuario, double salario) {
        this.professorIdUsuario = professorIdUsuario;
        this.salario = salario;
    }


    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getProfessorIdUsuario() {
        return professorIdUsuario;
    }

    public void setProfessorIdUsuario(int professorIdUsuario) {
        this.professorIdUsuario = professorIdUsuario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
