package com.bulletjournal.bulletjournal.repository;

import java.util.List;

import com.bulletjournal.bulletjournal.model.PostagemModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//PostagemModel é a entidade e long o tipo da mesma. No caso long
public interface PostagemRepository extends JpaRepository <PostagemModel,Long> {

    //Lista dos titulos da classe PostagemModel, procura todos os titulo, ignorando o case, se é maiusculo ou minusculo
    public List<PostagemModel>findAllByTituloContainingIgnoreCase(String titulo);

}
