package com.generation.lojadegames.model; // classe onde cria os atributos


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // create table // entidade = tabela
@Table(name =  "tb_catgoria") // nome da tabela
public class Categoria {
	
	@Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id; 
	
    @NotBlank(message = "O tipo é obrigatório!")
    @Size(max= 100)
    private String tipo;  
   
   @OneToMany(mappedBy= "categoria", cascade = CascadeType.REMOVE) // 1 para muitos //efeito cascata
   @JsonIgnoreProperties("categoria") // evitar loop
   private List<Produto> produto; // listagem

   // métodos GET/SET
   
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}

public List<Produto> getProduto() {
	return produto;
}

public void setProduto(List<Produto> produto) {
	this.produto = produto;
}

}
