package com.br.ifam.TodoApp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.br.ifam.TodoApp.model.Status;

public interface StatusRepository extends CrudRepository<Status, Long>{
    
   Optional<Status> findByTituloContaining(String titulo);

}
