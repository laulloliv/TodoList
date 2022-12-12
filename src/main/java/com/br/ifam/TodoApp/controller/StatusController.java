package com.br.ifam.TodoApp.controller;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import com.br.ifam.TodoApp.model.Status;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.ifam.TodoApp.repository.StatusRepository;

@RestController
@RequestMapping("/api/status")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Status> list(){
        List<Status> statuses = new ArrayList<>();
        statuses= (List<Status>) statusRepository.findAll();
        return statuses;
    }

    @GetMapping(value = "/{id}")
    public Status find(@PathVariable Long id){
        Optional<Status> status = statusRepository.findById(id);
        if (status.isPresent()){
            return status.get();
        }
        else {
            return null;
        }
    }

    @GetMapping(value = "/create")
    @ResponseBody
    public String create(){
        Status status1 = new Status("Para Fazer","Tarefa não iniciada.");
        Status status2 = new Status("Em Atraso","Tarefas que ultrapassaram a data prevista.");
        Status status3 = new Status("Concluída","Tarefa marcada como concluída.");

        statusRepository.save(status1);
        statusRepository.save(status2);
        statusRepository.save(status3);

        return "Status inseridos com Sucesso";
    }

    @GetMapping(value = "/titulo/{titulo}")
    public Status findByName(@PathVariable String titulo){
        Optional<Status> status = statusRepository.findByTituloContaining(titulo);
        return status.orElse(null);
    }

    @DeleteMapping(value = "{id}")
    @ResponseBody
    public String deleta(@PathVariable Long id){
        statusRepository.deleteById(id);
        return "Status excluido com Sucesso";
    }
}
