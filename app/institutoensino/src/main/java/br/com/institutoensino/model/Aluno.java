package br.com.institutoensino.model;

public class Aluno {
    private int idAluno;
    private int idUsuario;
    private String matricula;

    public Aluno() {}

    public Aluno(int idAluno, int idUsuario, String matricula) {
        this.idAluno = idAluno;
        this.idUsuario = idUsuario;
        this.matricula = matricula;
    }

    public Aluno(int idUsuario, String matricula) {
        this.idUsuario = idUsuario;
        this.matricula = matricula;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
