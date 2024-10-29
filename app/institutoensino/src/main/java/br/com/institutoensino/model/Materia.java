package br.com.institutoensino.model;

public class Materia {
    private int idMateria;
    private String nomeMateria;
    private int materiaIdCurso;
    private int materiaIdProfessor;

    public Materia() {
    }

    public Materia(int idMateria, String nomeMateria, int materiaIdCurso, int materiaIdProfessor) {
        this.idMateria = idMateria;
        this.nomeMateria = nomeMateria;
        this.materiaIdCurso = materiaIdCurso;
        this.materiaIdProfessor = materiaIdProfessor;
    }

    public Materia(String nomeMateria, int materiaIdCurso, int materiaIdProfessor) {
        this.nomeMateria = nomeMateria;
        this.materiaIdCurso = materiaIdCurso;
        this.materiaIdProfessor = materiaIdProfessor;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public int getMateriaIdCurso() {
        return materiaIdCurso;
    }

    public void setMateriaIdCurso(int materiaIdCurso) {
        this.materiaIdCurso = materiaIdCurso;
    }

    public int getMateriaIdProfessor() {
        return materiaIdProfessor;
    }

    public void setMateriaIdProfessor(int materiaIdProfessor) {
        this.materiaIdProfessor = materiaIdProfessor;
    }
}
