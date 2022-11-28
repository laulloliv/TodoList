package com.br.ifam.TodoApp.controller;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.br.ifam.TodoApp.model.Categoria;
import com.br.ifam.TodoApp.repository.CategoriaRepository;


@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    // Buscar pelo ID
    @GetMapping(value = "/{id}")
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
    @GetMapping(value="/titulo/{titulo}")
    public Categoria findByName(@PathVariable String titulo){
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
    @ResponseBody
    public String cadastrar(){
        Categoria categoria1 = new Categoria("TRABALHO","Tarefas relacionadas á 'trabalho'");
        Categoria categoria2 = new Categoria("VIAGEM","Tarefas relacionadas á 'viagem'");
        Categoria categoria3 = new Categoria("EDUCAÇÃO","Tarefas relacionadas á 'educação'");
        Categoria categoria4 = new Categoria("ESPORTES","Tarefas relacionadas á 'esportes'");
        Categoria categoria5 = new Categoria("OUTRAS","Tarefas relacionadas á 'outras'");

        categoriaRepository.save(categoria1);
        categoriaRepository.save(categoria2);
        categoriaRepository.save(categoria3);
        categoriaRepository.save(categoria4);
        categoriaRepository.save(categoria5);

        return "Categorias inseridas com Sucesso";
    }

    @DeleteMapping(value = "{id}")
    @ResponseBody
    public String deleta(@PathVariable Long id){
        categoriaRepository.deleteById(id);
        return "Categoria excluida com sucesso !";
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Categoria create (Categoria categoria){
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        return categoriaSalva;
    }
}
