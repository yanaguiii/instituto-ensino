package br.com.institutoensino.model;

import java.util.Date;

public class PostProfessor {
    private int idPost;
    private String conteudo;
    private Date data;
    private int idProfessor;
    private int idMateria;

    public PostProfessor() {}

    public PostProfessor(String conteudo, Date data, int idProfessor, int idMateria) {
        this.conteudo = conteudo;
        this.data = data;
        this.idProfessor = idProfessor;
        this.idMateria = idMateria;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }
}

