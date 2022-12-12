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
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
        Optional<Categoria> categoria5 = categoriaRepository.findById((long) 5);
        Optional<Categoria> categoria3 = categoriaRepository.findById((long) 3);
        Optional<Categoria> categoria4 = categoriaRepository.findById((long) 4);
        Optional<Status> status = statusRepository.findById((long) 1);
    //    System.out.println(categoria1.get());
    //    System.out.println(status.get());

        Tarefa tarefa = new Tarefa("Ir ao Mercado", "Comprar batatas, ovos e material para a lasanha", "12/03/2022", "12/12/2022",categoria5.get(),status.get());
        Tarefa tarefa2 = new Tarefa("Praticar algum Esporte", "Pesquisar academias perto de casa. Procurar por natacao ou basquete", "11/12/2022", "14/12/2022",categoria4.get(),status.get());
        Tarefa tarefa3 = new Tarefa("Fazer relatorio da Faculdade", "Atividade do prof. Alberto de Sistemas", "12/20/2022", "20/12/2022",categoria3.get(),status.get());

        System.out.println(tarefa);
        System.out.println(tarefa2);
        System.out.println(tarefa3);

        tarefaRepository.save(tarefa);
        tarefaRepository.save(tarefa2);
        tarefaRepository.save(tarefa3);

        return "Dados inserido";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TarefaOutputDTO> create(@RequestBody TarefaInputDTO dto, UriComponentsBuilder uriBuilder){
        Optional<Categoria> categoria = categoriaRepository.findById((long) dto.getCategoria().getId());
        Optional<Status> status = statusRepository.findById((long) dto.getStatus().getId());
        System.out.println(dto);
        Tarefa tarefa = dto.build(categoria.get(), status.get());
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

    @GetMapping(value = "/categoria/{titulo}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Tarefa> findCategoria(@PathVariable String titulo){
        List<Tarefa> tarefas = new ArrayList<>();
        Optional<Categoria> categoria = categoriaRepository.findByTitulo(titulo);
        if(categoria.isPresent()){
            tarefas = (List<Tarefa>) tarefaRepository.findAllByCategoria(categoria);
            System.out.println(tarefas);
            return tarefas;
        }
        else {
            ArrayList list= new ArrayList<>();
            list.add("Nenhuma tarefa encontrada!");
            return list;
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
            ArrayList list= new ArrayList<>();
            list.add("Nenhuma tarefa encontrada!");
            return list;
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
    @GetMapping(value = "/done/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TarefaOutputDTO> taskDone(@RequestBody TarefaInputDTO dto, @PathVariable Long id, UriComponentsBuilder uriBuilder){
        System.out.println(dto);
        Optional<Status> status = statusRepository.findById((long)3);
        Optional<Tarefa> tarefaAchada = tarefaRepository.findById(id);
        Tarefa tarefa = tarefaAchada.get();
        tarefa.setId(id);
        tarefa.setStatus(status.get());
        System.out.println(tarefa);
        tarefaRepository.save(tarefa);
        URI path = uriBuilder.path("/api/tarefas/{id}").buildAndExpand(id).toUri();

        return ResponseEntity.created(path).body(new TarefaOutputDTO(tarefa));
    }
    @GetMapping(value = "/doing/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TarefaOutputDTO> taskDoing(@RequestBody TarefaInputDTO dto, @PathVariable Long id, UriComponentsBuilder uriBuilder){
        System.out.println(dto);
        Optional<Status> status = statusRepository.findById((long)1);
        Optional<Tarefa> tarefaAchada = tarefaRepository.findById(id);
        Tarefa tarefa = tarefaAchada.get();
        tarefa.setId(id);
        tarefa.setStatus(status.get());
        System.out.println(tarefa);
        tarefaRepository.save(tarefa);
        URI path = uriBuilder.path("/api/tarefas/{id}").buildAndExpand(id).toUri();

        return ResponseEntity.created(path).body(new TarefaOutputDTO(tarefa));
    }

}
