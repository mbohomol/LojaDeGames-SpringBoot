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


import com.generation.lojadegames.model.Produto;
import com.generation.lojadegames.repository.ProdutoRepository;

@RestController //diz que é uma classe controladora Rest
@RequestMapping("/produto") 
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository; // acessa todos os métodos da Interface/Repository
	
	@GetMapping // para saber que esta chamando uma requisição, metódo que responde a requisição
	public ResponseEntity<List<Produto>> getAll(){ //por issso que tem que criar uma classe "Postagens", para poder importar
		return ResponseEntity.ok(produtoRepository.findAll()); // select * from tb_
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id){
		return produtoRepository.findById(id) // finById =Exibe um Objeto com um id específico.
					.map(resposta -> ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.notFound().build());
	}
		
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository.findAllByTituloContainingIgnoreCase(nome));
		}

	@PostMapping
	public ResponseEntity <Produto> postProduto(@Valid @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));		
	}
	
	@PutMapping
	public ResponseEntity <Produto> putProduto(@Valid @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.save(produto));
	}
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		produtoRepository.deleteById(id);
		
	
	
	
	
	
	}
}
	
	
	
	

