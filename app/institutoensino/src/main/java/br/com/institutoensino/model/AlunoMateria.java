package br.com.institutoensino.model;

import java.math.BigDecimal;

public class AlunoMateria {
    private int idAluno;
    private int idMateria;
    private BigDecimal nota;
    private int faltas;

    public AlunoMateria() {
    }

    public AlunoMateria(int idAluno, int idMateria, BigDecimal nota, int faltas) {
        this.idAluno = idAluno;
        this.idMateria = idMateria;
        this.nota = nota;
        this.faltas = faltas;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
}
