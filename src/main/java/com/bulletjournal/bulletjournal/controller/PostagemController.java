package com.bulletjournal.bulletjournal.controller;

import java.util.List;

import com.bulletjournal.bulletjournal.model.PostagemModel;
import com.bulletjournal.bulletjournal.repository.PostagemRepository;

import org.apache.catalina.connector.Response;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/postagens")//URI que verifica requisições de nome postagens, para 'iniciar' a classe PostagemController.
@CrossOrigin("*")//Aceita requisição de todas as origens
public class PostagemController {

    @Autowired //Coloca a responsabilidade de gerenciar/instanciar pro Spring
    private PostagemRepository repository;
    
    @GetMapping //Verifica o método da requição e SE for GET, dispara esse método
    public ResponseEntity<List<PostagemModel>>GetAll()
    {
        return ResponseEntity.ok(repository.findAll());
    }
}
