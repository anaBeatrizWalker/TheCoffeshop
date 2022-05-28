package com.coffeshop.model;

import java.util.List;
import java.util.Map;
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
		
		/* ***CADASTRAR BEBIDAS*** */
		public void postBebida(Bebidas bebida) {
			String sql = "INSERT INTO bebidas(nome, descricao, preco, categoria, tamanho)" +
							"VALUES (?, ?, ?, ?, ?)";
			Object[] obj = new Object[5];
			obj[0] = bebida.getNome();
			obj[1] = bebida.getDescricao();
			obj[2] = bebida.getPreco();
			obj[3] = bebida.getCategoria();
			obj[4] = bebida.getTamanho();
			jdbc.update(sql, obj);
		}
		
		/* ***VISUALIZAR BEBIDA*** */
		public Map<String, Object> getBebida(int id){
			String sql = "SELECT * FROM bebidas WHERE bebidas.id = ?";
			Object[] obj = new Object[1];
			obj[0] = id; 
			return jdbc.queryForMap(sql, obj);
		}
		
		/* ***VISUALIZAR BEBIDAS*** */
		public List<Map<String, Object>> getBebidas(){
			String sql = "SELECT * FROM bebidas";
			List<Map<String, Object>> bebidas = (List<Map<String, Object>>) jdbc.queryForList(sql);
			return bebidas;
		}
		
		/* ***DELETAR BEBIDA*** */
		public void delBebidas(int id) {
			String sql = "DELETE FROM bebidas WHERE bebidas.id = ?";
			Object[] obj = new Object[1];
			obj[0] = id; 
			jdbc.update(sql, obj);
		}
		
		/* ***ATUALIZAR BEBIDA*** */
		public void updBebidas(int id, Bebidas bebida) {
			String sql = "UPDATE bebidas SET nome = ?, descricao = ?, preco = ?, categoria = ?, tamanho = ? WHERE id = ?";
			Object[] obj = new Object[6];
			obj[0] = bebida.getNome();
			obj[1] = bebida.getDescricao();
			obj[2] = bebida.getPreco();
			obj[3] = bebida.getCategoria();
			obj[4] = bebida.getTamanho();
			obj[5] = id;
			jdbc.update(sql, obj);
		}
}
