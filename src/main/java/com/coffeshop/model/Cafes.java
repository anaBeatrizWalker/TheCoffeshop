package com.coffeshop.model;

public class Cafes {

	private int id;
	private String nome, descricao, fornecedor, preco, gramas;
	
	public Cafes() {
		
	}

	public Cafes(int id, String nome, String descricao, String fornecedor, String preco, String gramas) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.fornecedor = fornecedor;
		this.preco = preco;
		this.gramas = gramas;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getGramas() {
		return gramas;
	}

	public void setGramas(String gramas) {
		this.gramas = gramas;
	}	
}
