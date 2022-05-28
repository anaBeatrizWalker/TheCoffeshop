package com.coffeshop.model;

import java.util.List; 
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComidasService {
	
	@Autowired
	ComidasDAO cdao;
	
	public void postComida(Comidas c) {
		cdao.postComida(c);
	}
	
	public Map<String, Object> getComida(int id) {
		return cdao.getComida(id);
	}

	public List<Map<String, Object>> getComidas(){
		return cdao.getComidas();
	}
	
	public void delComida(int id) {
		cdao.delComida(id);
	}
	
	public void putComida(int id, Comidas c) {
		cdao.putComida(id, c);
	}
}
