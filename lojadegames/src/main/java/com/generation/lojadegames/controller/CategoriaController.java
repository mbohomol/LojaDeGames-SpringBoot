package com.generation.lojadegames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.generation.lojadegames.model.Categoria;
import com.generation.lojadegames.repository.CategoriaRepository;


@RestController //diz que é uma classe controladora Rest
@RequestMapping("/categoria") // mapeia os endpoints, para receber requisições 
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository; // acessa todos os métodos da Interface/Repository
	
	@GetMapping // para saber que esta chamando uma requisição, metódo que responde a requisição
	public ResponseEntity<List<Categoria>> getAll(){ 
		return ResponseEntity.ok(categoriaRepository.findAll()); // select * from tb_
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id){
		return categoriaRepository.findById(id) // finById =Exibe um Objeto com um id específico.
					.map(resposta -> ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.notFound().build());
	}
		
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity <List<Categoria>>getByTipo(@PathVariable String tipo){
		return ResponseEntity.ok(categoriaRepository.findAllByTituloContainingIgnoreCase(tipo)); 
		}

	@PostMapping
	public ResponseEntity <Categoria> postCategoria(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));		
	}
	
	@PutMapping
	public ResponseEntity <Categoria> putCategoria(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
	}
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable Long id) {
		categoriaRepository.deleteById(id);
		
	}

}
	
	
	
	
	
	
