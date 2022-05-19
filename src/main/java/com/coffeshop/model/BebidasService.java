package com.coffeshop.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BebidasService {
	
	@Autowired
	BebidasDAO bdao;
	
	public void inserirBebida(Bebidas b) {
		bdao.inserirBebida(b);
	}
}
