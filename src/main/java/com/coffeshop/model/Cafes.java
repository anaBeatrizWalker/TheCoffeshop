package com.coffeshop.model;

public class Cafes {

	private int id;
	private String nome, descriçao, fornecedor;
	private int preço, gramas;
	
	public Cafes() {
		
	}

	public Cafes(int id, String nome, String descriçao, String fornecedor, int preço, int gramas) {
		this.id = id;
		this.nome = nome;
		this.descriçao = descriçao;
		this.fornecedor = fornecedor;
		this.preço = preço;
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

	public String getDescriçao() {
		return descriçao;
	}

	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public int getPreço() {
		return preço;
	}

	public void setPreço(int preço) {
		this.preço = preço;
	}

	public int getGramas() {
		return gramas;
	}

	public void setGramas(int gramas) {
		this.gramas = gramas;
	}	
}
