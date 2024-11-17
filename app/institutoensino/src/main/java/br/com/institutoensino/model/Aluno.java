package br.com.institutoensino.model;

public class Aluno {
    private int idAluno;
    private int alunoIdUsuario;

    public Aluno() {
    }

    public Aluno(int idAluno, int alunoIdUsuario) {
        this.idAluno = idAluno;
        this.alunoIdUsuario = alunoIdUsuario;
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

}
