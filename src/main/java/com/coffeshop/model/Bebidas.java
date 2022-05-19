package com.coffeshop.model;

public class Bebidas {
	
	private int id;
	private String nome, descriçao, categoria, tamanho;
	private int preço;
	
	public Bebidas() {
		
	}

	public Bebidas(int id, String nome, String descriçao, String categoria, int preço, String tamanho) {
		this.id = id;
		this.nome = nome;
		this.descriçao = descriçao;
		this.categoria = categoria;
		this.preço = preço;
		this.tamanho = tamanho;
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

	public String getDescriçao() {
		return descriçao;
	}

	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getPreço() {
		return preço;
	}

	public void setPreço(int preço) {
		this.preço = preço;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}	
}
