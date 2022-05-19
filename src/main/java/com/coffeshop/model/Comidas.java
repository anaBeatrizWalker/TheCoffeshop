package com.coffeshop.model;

public class Comidas {
	
	private int id;
	private String nome, descriçao, categoria;
	private int preço;
	
	public Comidas() {
		
	}

	public Comidas(int id, String nome, String descriçao, String categoria, int preço) {
		this.id = id;
		this.nome = nome;
		this.descriçao = descriçao;
		this.categoria = categoria;
		this.preço = preço;
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
}
