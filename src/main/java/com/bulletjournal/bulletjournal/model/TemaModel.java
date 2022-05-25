package com.bulletjournal.bulletjournal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity//entidade = a uma tabela
@Table(name = "tema")
public class TemaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    @NotNull
    private String descricao;

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

 
    @OneToMany(mappedBy = "tema", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("tema")
    private List<PostagemModel> post;

    public List<PostagemModel> getPost(){
        return post;
    }

    public void setPost(List<PostagemModel> post){
        this.post = post;
    }
}
