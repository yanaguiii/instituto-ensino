package br.com.institutoensino.model;

import java.util.Date;

public class PostProfessor {
    private int idPost;
    private String conteudo;
    private Date data;
    private int postIdProfessor;
    private int postIdMateria;

    public PostProfessor() {
    }

    public PostProfessor(int idPost, String conteudo, Date data, int postIdProfessor, int postIdMateria) {
        this.idPost = idPost;
        this.conteudo = conteudo;
        this.data = data;
        this.postIdProfessor = postIdProfessor;
        this.postIdMateria = postIdMateria;
    }

    public PostProfessor(String conteudo, Date data, int postIdProfessor, int postIdMateria) {
        this.conteudo = conteudo;
        this.data = data;
        this.postIdProfessor = postIdProfessor;
        this.postIdMateria = postIdMateria;
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

    public int getPostIdProfessor() {
        return postIdProfessor;
    }

    public void setPostIdProfessor(int postIdProfessor) {
        this.postIdProfessor = postIdProfessor;
    }

    public int getPostIdMateria() {
        return postIdMateria;
    }

    public void setPostIdMateria(int postIdMateria) {
        this.postIdMateria = postIdMateria;
    }
}

