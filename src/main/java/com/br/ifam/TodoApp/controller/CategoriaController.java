package com.br.ifam.TodoApp.controller;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.ifam.TodoApp.model.Categoria;
import com.br.ifam.TodoApp.repository.CategoriaRepository;


@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    // Buscar pelo ID
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Categoria find(@PathVariable Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()){
            return categoria.get();
        }
        else{
            return null;
        }
    }

    // Buscar pelo TITULO
    @GetMapping(value="/{titulo}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Categoria find(@PathVariable String titulo){
        Optional<Categoria> categoria = categoriaRepository.findByTituloContaining(titulo);
        if(categoria.isPresent()){
            return categoria.get();
        }
        else{
            return null;
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Categoria> list(){

        List<Categoria> categorias = new ArrayList<>();
        categorias= (List<Categoria>) categoriaRepository.findAll();
        return categorias;
    }

    @GetMapping(value = "/cadastrar")
    @RequestMapping
    public String add(){
        Categoria categoria1 = new Categoria();
        Categoria categoria2 = new Categoria();
        Categoria categoria3 = new Categoria();

        categoriaRepository.save(categoria1);
        categoriaRepository.save(categoria2);
        categoriaRepository.save(categoria3);

        return "Categorias inseridas com Sucesso";
    }

    @DeleteMapping(value = "{id}")
    @ResponseBody
    public String deleta(@PathVariable Long id){
        categoriaRepository.deleteById(id);
        return "Categoria excluida com sucesso !";
    }
}
