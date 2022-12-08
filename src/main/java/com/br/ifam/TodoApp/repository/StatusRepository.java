package com.br.ifam.TodoApp.repository;

import java.util.Optional;

import com.br.ifam.TodoApp.model.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Long>{
    
   Optional<Status> findByTituloContaining(String titulo);

}
