package com.coffeshop.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ComidasDAO {
	
		@Autowired
		DataSource dataSource;
		
		JdbcTemplate jdbc;
		
		@PostConstruct
		private void initialize() {
			jdbc = new JdbcTemplate(dataSource);
		}
		
		public void inserirComida(Comidas comida) {
			String sql = "INSERT INTO comidas(nome, descriçao, preço, categoria)" +
							"VALUES (?, ?, ?, ?)";
			Object[] obj = new Object[4];
			obj[0] = comida.getNome();
			obj[1] = comida.getDescriçao();
			obj[2] = comida.getPreço();
			obj[3] = comida.getCategoria();
			jdbc.update(sql, obj);
		}
}
