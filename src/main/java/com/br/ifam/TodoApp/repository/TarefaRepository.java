package com.br.ifam.TodoApp.repository;

import com.br.ifam.TodoApp.model.Categoria;
import com.br.ifam.TodoApp.model.Status;
import com.br.ifam.TodoApp.model.Tarefa;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TarefaRepository extends CrudRepository<Tarefa, Long> {

    Optional<Tarefa> findByTituloContaining(String titulo);
    Iterable<Tarefa> findAllByCategoria(Optional<Categoria> categoria);
    Iterable<Tarefa> findAllByStatus(Optional<Status> status);


}
