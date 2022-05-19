package com.coffeshop.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComidasService {
	
	@Autowired
	ComidasDAO cdao;
	
	public void inserirComida(Comidas c) {
		cdao.inserirComida(c);
	}
}
