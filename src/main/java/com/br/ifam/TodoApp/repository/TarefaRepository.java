package com.br.ifam.TodoApp.repository;

import com.br.ifam.TodoApp.model.Tarefa;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TarefaRepository extends CrudRepository<Tarefa, Long> {

    Optional<Tarefa> findByTituloContaining(String titulo);

}
