package com.generation.lojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.lojadegames.model.Categoria;

@Repository //criação de uma interface "Repository"
public interface CategoriaRepository extends JpaRepository <Categoria, Long>{

	public List <Categoria> findAllByTipoContainingIgnoreCase(String tipo);  // acessa o banco de dados e busca informações // interage com o banco de dados
}

