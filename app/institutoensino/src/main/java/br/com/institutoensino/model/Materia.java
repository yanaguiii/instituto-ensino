package br.com.institutoensino.model;

public class Materia {
    private int idMateria;
    private String nome;
    private int idCurso;
    private int idProfessor;

    public Materia() {}

    public Materia(int idMateria, String nome, int idCurso, int idProfessor) {
        this.idMateria = idMateria;
        this.nome = nome;
        this.idCurso = idCurso;
        this.idProfessor = idProfessor;
    }

    public Materia(String nome, int idCurso, int idProfessor) {
        this.nome = nome;
        this.idCurso = idCurso;
        this.idProfessor = idProfessor;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
}
