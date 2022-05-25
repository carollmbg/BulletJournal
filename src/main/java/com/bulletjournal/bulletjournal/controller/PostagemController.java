package com.bulletjournal.bulletjournal.controller;

import java.util.List;

import com.bulletjournal.bulletjournal.model.PostagemModel;
import com.bulletjournal.bulletjournal.repository.PostagemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/postagem")//URI que verifica requisições de nome postagens, para 'iniciar' a classe PostagemController.
@CrossOrigin("*")//Aceita requisição de todas as origens
public class PostagemController {

    @Autowired //Coloca a responsabilidade de gerenciar/instanciar pro Spring
    private PostagemRepository repository;
    
    @GetMapping //Verifica o método da requição e SE for GET, dispara esse método
    public ResponseEntity<List<PostagemModel>>GetAll()
    {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostagemModel> GetById(@PathVariable long id) {
        return repository.findById(id)
        .map(resp -> ResponseEntity.ok(resp))
        .orElse((ResponseEntity.notFound().build()));
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<PostagemModel>> GetIdByTitulo(@PathVariable String titulo){

        return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
    }

    @PostMapping
    public ResponseEntity<PostagemModel> post (@RequestBody PostagemModel post){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(post));
    }

    @PutMapping
    public ResponseEntity<PostagemModel> put (@RequestBody PostagemModel post){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(post));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }
}
