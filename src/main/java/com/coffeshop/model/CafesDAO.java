package com.coffeshop.model;

import java.util.List;
import java.util.Map;
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
		
		/* ***CADASTRAR CAFES*** */
		public void postCafe(Cafes cafe) {
			String sql = "INSERT INTO cafes(nome, descricao, fornecedor, preco, gramas)" +
							"VALUES (?, ?, ?, ?, ?)";
			Object[] obj = new Object[5];
			obj[0] = cafe.getNome();
			obj[1] = cafe.getDescricao();
			obj[2] = cafe.getFornecedor();
			obj[3] = cafe.getPreco();
			obj[4] = cafe.getGramas();
			jdbc.update(sql, obj);
		}
		
		/* ***VISUALIZAR CAFE*** */
		public Map<String, Object> getCafe(int id){
			String sql = "SELECT * FROM cafes WHERE cafes.id = ?";
			Object[] obj = new Object[1];
			obj[0] = id; 
			return jdbc.queryForMap(sql, obj);
		}
		
		/* ***LISTA DE CAFES*** */
		public List<Map<String, Object>> getCafes(){
			String sql = "SELECT * FROM cafes";
			List<Map<String, Object>> cafes = (List<Map<String, Object>>) jdbc.queryForList(sql);
			return cafes;
		}
		
		/* ***DELETAR CAFE*** */
		public void delCafes(int id) {
			String sql = "DELETE FROM cafes WHERE cafes.id = ?";
			Object[] obj = new Object[1];
			obj[0] = id; 
			jdbc.update(sql, obj);
		}
		
		/* ***ATUALIZAR CAFE*** */
		public void updCafes(int id, Cafes cafe) {
			String sql = "UPDATE cafes SET nome = ?, descricao = ?,  fornecedor = ?, preco = ?, gramas = ? WHERE id = ?";
			Object[] obj = new Object[6];
			obj[0] = cafe.getNome();
			obj[1] = cafe.getDescricao();
			obj[2] = cafe.getFornecedor();
			obj[3] = cafe.getPreco();
			obj[4] = cafe.getGramas();
			obj[5] = id;
			jdbc.update(sql, obj);
		}
}
