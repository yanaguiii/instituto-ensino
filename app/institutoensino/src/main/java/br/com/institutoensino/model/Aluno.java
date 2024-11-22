package br.com.institutoensino.model;

public class Aluno {
    private int idAluno;
    private int alunoIdUsuario;
    private int alunoIdCurso;

    public Aluno() {
    }

    public Aluno(int idAluno, int alunoIdUsuario, int alunoIdCurso) {
        this.idAluno = idAluno;
        this.alunoIdUsuario = alunoIdUsuario;
        this.alunoIdCurso = alunoIdCurso;
    }

    public Aluno(int alunoIdUsuario, int alunoIdCurso) {
        this.alunoIdUsuario = alunoIdUsuario;
        this.alunoIdCurso = alunoIdCurso;
    }

    public Aluno(int alunoIdUsuario) {
        this.alunoIdUsuario = alunoIdUsuario;
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

    public int getAlunoIdCurso() {
        return alunoIdCurso;
    }

    public void setAlunoIdCurso(int alunoIdCurso) {
        this.alunoIdCurso = alunoIdCurso;
    }

}
