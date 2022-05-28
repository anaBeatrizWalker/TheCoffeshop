package com.coffeshop.model;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BebidasService {
	
	@Autowired
	BebidasDAO bdao;
	
	public void postBebida(Bebidas b) {
		bdao.postBebida(b);
	}
	
	public Map<String, Object> getBebida(int id) {
		return bdao.getBebida(id);
	}

	public List<Map<String, Object>> getBebidas(){
		return bdao.getBebidas();
	}
	
	public void delBebidas(int id) {
		bdao.delBebidas(id);
	}
	
	public void updBebidas(int id, Bebidas b) {
		bdao.updBebidas(id, b);
	}
}
