package com.br.ifam.TodoApp.repository;

import com.br.ifam.TodoApp.model.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaRepository extends CrudRepository<Categoria, Long>{

   Optional<Categoria> findByTituloContaining(String titulo);


}
