package com.coffeshop.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CafesDAO {
	
		@Autowired
		DataSource dataSource;
		
		JdbcTemplate jdbc;
		
		@PostConstruct
		private void initialize() {
			jdbc = new JdbcTemplate(dataSource);
		}
		
		public void inserirCafe(Cafes cafe) {
			String sql = "INSERT INTO cafes(nome, descriçao, fornecedor, preço, gramas)" +
							"VALUES (?, ?, ?, ?, ?)";
			Object[] obj = new Object[5];
			obj[0] = cafe.getNome();
			obj[1] = cafe.getDescriçao();
			obj[2] = cafe.getFornecedor();
			obj[3] = cafe.getPreço();
			obj[4] = cafe.getGramas();
			jdbc.update(sql, obj);
		}
}
