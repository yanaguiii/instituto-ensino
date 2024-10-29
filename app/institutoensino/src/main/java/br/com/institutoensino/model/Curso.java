package br.com.institutoensino.model;

public class Curso {
    private int idCurso;
    private String nomeCurso;
    private String modalidade;
    private Float duracao;
    private String campus;
    private String turno;
    private String descricao;

    public Curso() {
    }

    public Curso(int idCurso, String nomeCurso, String modalidade, Float duracao, String campus, String turno, String descricao) {
        this.idCurso = idCurso;
        this.nomeCurso = nomeCurso;
        this.modalidade = modalidade;
        this.duracao = duracao;
        this.campus = campus;
        this.turno = turno;
        this.descricao = descricao;
    }

    public Curso(String nomeCurso, String modalidade, Float duracao, String campus, String turno, String descricao) {
        this.nomeCurso = nomeCurso;
        this.modalidade = modalidade;
        this.duracao = duracao;
        this.campus = campus;
        this.turno = turno;
        this.descricao = descricao;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public Float getDuracao() {
        return duracao;
    }

    public void setDuracao(Float duracao) {
        this.duracao = duracao;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
