package com.coffeshop.model;

import java.util.List;
import java.util.Map;
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
		/* ***CADASTRAR*** */
		public void postComida(Comidas comida) {
			String sql = "INSERT INTO comidas(nome, descricao, preco, categoria)" +
							"VALUES (?, ?, ?, ?)";
			Object[] obj = new Object[4];
			obj[0] = comida.getNome();
			obj[1] = comida.getDescricao();
			obj[2] = comida.getPreco();
			obj[3] = comida.getCategoria();
			jdbc.update(sql, obj);
		}
		
		/* ***VISUALIZAR UM*** */
		public Map<String, Object> getComida(int id){
			String sql = "SELECT * FROM comidas WHERE comidas.id = ?";
			Object[] obj = new Object[1];
			obj[0] = id; 
			return jdbc.queryForMap(sql, obj);
		}
		
		/* ***VISUALIZAR TODAS*** */
		public List<Map<String, Object>> getComidas(){
			String sql = "SELECT * FROM comidas";
			List<Map<String, Object>> comidas = (List<Map<String, Object>>) jdbc.queryForList(sql);
			return comidas;
		}
		
		/* ***DELETAR*** */
		public void delComida(int id) {
			String sql = "DELETE FROM comidas WHERE comidas.id = ?";
			Object[] obj = new Object[1];
			obj[0] = id; 
			jdbc.update(sql, obj);
		}
		
		/* ***ATUALIZAR*** */
		public void putComida(int id, Comidas comida) {
			String sql = "UPDATE comidas SET nome = ?, descricao = ?, preco = ?, categoria = ? WHERE id = ?";
			Object[] obj = new Object[5];
			obj[0] = comida.getNome();
			obj[1] = comida.getDescricao();
			obj[2] = comida.getPreco();
			obj[3] = comida.getCategoria();
			obj[4] = id;
			jdbc.update(sql, obj);
		}
}
