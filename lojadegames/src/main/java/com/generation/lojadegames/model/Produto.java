package com.generation.lojadegames.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // create table // entidade = tabela
@Table(name =  "tb_produto") // nome da tabela
public class Produto {

	@Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id; 
	
    @NotBlank(message = "O nome é obrigatório!")
    @Size(max= 1000)
    private String nome;  

    @NotBlank(message = "A descrição é obrigatória!")
    @Size(min= 10)
    private String descricao; 
    
    @PositiveOrZero
    private int quantidade; 
    
    @Positive
    private BigDecimal preco; 

    @NotBlank(message = "A foto é obrigatória!")
    private String foto;
    
    @ManyToOne // Muitos para 1
    @JsonIgnoreProperties("produto") // serve para não ser um loop infinito
    private Categoria categoria;  // cria o objeto categoria
    
 // métodos GET/SET
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
