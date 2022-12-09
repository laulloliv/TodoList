package com.br.ifam.TodoApp.controller;

import com.br.ifam.TodoApp.dto.TarefaInputDTO;
import com.br.ifam.TodoApp.dto.TarefaOutputDTO;
import com.br.ifam.TodoApp.model.Categoria;
import com.br.ifam.TodoApp.model.Status;
import com.br.ifam.TodoApp.model.Tarefa;
import com.br.ifam.TodoApp.repository.CategoriaRepository;
import com.br.ifam.TodoApp.repository.StatusRepository;
import com.br.ifam.TodoApp.repository.TarefaRepository;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private StatusRepository statusRepository;

    @GetMapping("/create")
    @ResponseBody
    public String create(){
        Optional<Categoria> categoria = categoriaRepository.findById((long) 20);
        Optional<Status> status = statusRepository.findById((long) 5);
        System.out.println(categoria.get());
        System.out.println(status.get());
        if (categoria.isPresent() && status.isPresent()){
            Tarefa tarefa = new Tarefa("Mercado", "One", "13/02/2022", "14/09/2022",categoria.get(),status.get());
            Tarefa tarefa2 = new Tarefa("Esporte", "One", "15/12/2022", "22/12/2022",categoria.get(),status.get());
            Tarefa tarefa3 = new Tarefa("Faculdade", "One", "03/06/2022", "11/10/2022",categoria.get(),status.get());

            System.out.println(tarefa);
            System.out.println(tarefa2);
            System.out.println(tarefa3);

            tarefaRepository.save(tarefa);
            tarefaRepository.save(tarefa2);
            tarefaRepository.save(tarefa3);

            return "Dados inserido";

        }
        else{
            return "Erro !";
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TarefaOutputDTO> create(@RequestBody TarefaInputDTO dto, UriComponentsBuilder uriBuilder){

        System.out.println(dto);
        Tarefa tarefa = dto.build();
        System.out.println(tarefa);
        tarefaRepository.save(tarefa);
        URI path = uriBuilder.path("/api/tarefas/{id}").buildAndExpand(tarefa.getId()).toUri();

        return ResponseEntity.created(path).body(new TarefaOutputDTO(tarefa));
    }
    @PostMapping(value = "/update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TarefaOutputDTO> update(@RequestBody TarefaInputDTO dto, @PathVariable Long id, UriComponentsBuilder uriBuilder){
        System.out.println(dto);
        Tarefa tarefa = dto.build();
        tarefa.setId(id);
        System.out.println(tarefa);
        tarefaRepository.save(tarefa);
        URI path = uriBuilder.path("/api/tarefas/{id}").buildAndExpand(id).toUri();

        return ResponseEntity.created(path).body(new TarefaOutputDTO(tarefa));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Tarefa findById(@PathVariable Long id){
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.orElse(null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Tarefa> findAll(){
        List<Tarefa> tarefas = new ArrayList<>();
        tarefas = (List<Tarefa>)tarefaRepository.findAll();
        return tarefas;
    }


    @GetMapping(value = "/categoria/{titulo}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Tarefa> findCategoria(@PathVariable String titulo){
        List<Tarefa> tarefas = new ArrayList<>();
        Optional<Categoria> categoria = categoriaRepository.findByTituloContaining(titulo);
        if(categoria.isPresent()){
            tarefas = (List<Tarefa>) tarefaRepository.findAllByCategoria(categoria);
            System.out.println(tarefas);
            return tarefas;
        }
        else {
            return null;
        }
    }
    @GetMapping(value = "/status/{titulo}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Tarefa> findStatus(@PathVariable String titulo){
        List<Tarefa> tarefas = new ArrayList<>();
        Optional<Status> status = statusRepository.findByTituloContaining(titulo);
        if(status.isPresent()){
            tarefas = (List<Tarefa>) tarefaRepository.findAllByStatus(status);
            System.out.println(tarefas);
            return tarefas;
        }
        else {
            return null;
        }
    }

    @GetMapping(value = "/titulo/{titulo}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Tarefa findByName(@PathVariable String titulo){
        Optional<Tarefa> tarefa = tarefaRepository.findByTituloContaining(titulo);
        return tarefa.orElse(null);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        tarefaRepository.deleteById(id);
        return "Atenção! Tarefa deletada.";
    }



}
