package com.coffeshop.model;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafesService {
	
	@Autowired
	CafesDAO cadao;
	
	public void postCafe(Cafes c) {
		cadao.postCafe(c);
	}
	
	public Map<String, Object> getCafe(int id) {
		return cadao.getCafe(id);
	}

	public List<Map<String, Object>> getCafes(){
		return cadao.getCafes();
	}
	
	public void delCafes(int id) {
		cadao.delCafes(id);
	}
	
	public void updCafes(int id, Cafes c) {
		cadao.updCafes(id, c);
	}
}
