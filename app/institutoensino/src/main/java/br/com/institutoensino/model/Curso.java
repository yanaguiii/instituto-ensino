package br.com.institutoensino.model;

public class Curso {
    private int idCurso;
    private String nome;
    private String modalidade;
    private float duracao;
    private String campus;
    private String turno;
    private String descricao;

    public Curso() {
    }

    public Curso(int idCurso, String nome, String modalidade, float duracao, String campus, String turno, String descricao) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.modalidade = modalidade;
        this.duracao = duracao;
        this.campus = campus;
        this.turno = turno;
        this.descricao = descricao;
    }

    public Curso(String nome, String modalidade, float duracao, String campus, String turno, String descricao) {
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public float getDuracao() {
        return duracao;
    }

    public void setDuracao(float duracao) {
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
