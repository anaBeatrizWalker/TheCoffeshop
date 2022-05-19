package com.coffeshop.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafesService {
	
	@Autowired
	CafesDAO cadao;
	
	public void inserirCafe(Cafes c) {
		cadao.inserirCafe(c);
	}
}
