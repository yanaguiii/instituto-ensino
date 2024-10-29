package br.com.institutoensino.model;

public class Aluno {
    private int idAluno;
    private int alunoIdUsuario;
    private String matricula;

    public Aluno() {
    }

    public Aluno(int idAluno, int alunoIdUsuario, String matricula) {
        this.idAluno = idAluno;
        this.alunoIdUsuario = alunoIdUsuario;
        this.matricula = matricula;
    }

    public Aluno(int alunoIdUsuario, String matricula) {
        this.alunoIdUsuario = alunoIdUsuario;
        this.matricula = matricula;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getAlunoIdUsuario() {
        return alunoIdUsuario;
    }

    public void setAlunoIdUsuario(int alunoIdUsuario) {
        this.alunoIdUsuario = alunoIdUsuario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
