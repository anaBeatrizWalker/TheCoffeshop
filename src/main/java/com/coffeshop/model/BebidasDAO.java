package com.coffeshop.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BebidasDAO {
	
		@Autowired
		DataSource dataSource;
		
		JdbcTemplate jdbc;
		
		@PostConstruct
		private void initialize() {
			jdbc = new JdbcTemplate(dataSource);
		}
		
		public void inserirBebida(Bebidas bebida) {
			String sql = "INSERT INTO bebidas(nome, descriçao, preço, categoria, tamanho)" +
							"VALUES (?, ?, ?, ?, ?)";
			Object[] obj = new Object[5];
			obj[0] = bebida.getNome();
			obj[1] = bebida.getDescriçao();
			obj[2] = bebida.getPreço();
			obj[3] = bebida.getCategoria();
			obj[4] = bebida.getTamanho();
			jdbc.update(sql, obj);
		}
}
