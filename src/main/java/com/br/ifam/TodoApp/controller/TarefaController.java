package com.br.ifam.TodoApp.controller;

import com.br.ifam.TodoApp.dto.TarefaInputDTO;
import com.br.ifam.TodoApp.dto.TarefaOutputDTO;
import com.br.ifam.TodoApp.model.Tarefa;
import com.br.ifam.TodoApp.repository.TarefaRepository;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @GetMapping("/create")
    @ResponseBody
    public String create(){
        Tarefa tarefa = new Tarefa("Mercado", "One", "13/02/2022", "14/09/2022");
        Tarefa tarefa2 = new Tarefa("Esporte", "One", "15/12/2022", "22/12/2022");
        Tarefa tarefa3 = new Tarefa("Faculdade", "One", "03/06/2022", "11/10/2022");

        tarefaRepository.save(tarefa);
        tarefaRepository.save(tarefa2);
        tarefaRepository.save(tarefa3);

        return "Dados inserido";
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