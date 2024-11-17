package br.com.institutoensino.model;

import java.math.BigDecimal;

public class AlunoMateria {
    private int alunoMateriaIdAluno;
    private int alunoMateriaIdMateria;
    private BigDecimal nota;
    private int faltas;

    public AlunoMateria() {
    }

    public AlunoMateria(int alunoMateriaIdAluno, int alunoMateriaIdMateria, BigDecimal nota, int faltas) {
        this.alunoMateriaIdAluno = alunoMateriaIdAluno;
        this.alunoMateriaIdMateria = alunoMateriaIdMateria;
        this.nota = nota;
        this.faltas = faltas;
    }

    public AlunoMateria(int alunoMateriaIdAluno, int alunoMateriaIdMateria) {
        this.alunoMateriaIdAluno = alunoMateriaIdAluno;
        this.alunoMateriaIdMateria = alunoMateriaIdMateria;
    }

    public int getAlunoMateriaIdAluno() {
        return alunoMateriaIdAluno;
    }

    public void setAlunoMateriaIdAluno(int alunoMateriaIdAluno) {
        this.alunoMateriaIdAluno = alunoMateriaIdAluno;
    }

    public int getAlunoMateriaIdMateria() {
        return alunoMateriaIdMateria;
    }

    public void setAlunoMateriaIdMateria(int alunoMateriaIdMateria) {
        this.alunoMateriaIdMateria = alunoMateriaIdMateria;
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
