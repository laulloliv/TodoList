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

import com.br.ifam.TodoApp.model.Status;
import com.br.ifam.TodoApp.repository.StatusRepository;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    
    @Autowired
    private StatusRepository statusRepository;

    @GetMapping(value="/titulo/{titulo}")
    public Status find(@PathVariable String titulo){
        Optional<Status> statu = statusRepository.findByTituloContaining(titulo);
        if(statu.isPresent()){
            return statu.get();
        }
        else{
            return null;
        }
    }

    @GetMapping(value = "/{id}")
    public Status find(@PathVariable Long id){
        Optional<Status> statu = statusRepository.findById(id);
        if(statu.isPresent()){
            return statu.get();
        }
        else{
            return null;
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Status> list(){

        List<Status> statu = new ArrayList<>();
        statu= (List<Status>) statusRepository.findAll();
        return statu;
    }

    @GetMapping(value = "/cadastrar")
    @RequestMapping
    public String add(){
        Status status1 = new Status("FEITO");
        Status status2 = new Status("EM ANDAMENTO");
        Status status3 = new Status("NÃO INICIADO");

        statusRepository.save(status1);
        statusRepository.save(status2);
        statusRepository.save(status3);

        return "Status inseridas com Sucesso";
    }

    @DeleteMapping(value = "{id}")
    @ResponseBody
    public String deleta(@PathVariable Long id){
        statusRepository.deleteById(id);
        return "Status excluida com sucesso !";
    }

}
