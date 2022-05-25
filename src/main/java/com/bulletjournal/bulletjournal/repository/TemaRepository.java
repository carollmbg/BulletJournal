package com.bulletjournal.bulletjournal.repository;

import java.util.List;

import com.bulletjournal.bulletjournal.model.TemaModel;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TemaRepository extends JpaRepository< TemaModel, Long> {

    public List<TemaModel> findAllDescricaoContainingIgnoreCase(String descricao);
    
    
}
