package com.coffeshop.cadastro;

import org.springframework.context.ApplicationContext;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.coffeshop.model.Comidas;
import com.coffeshop.model.ComidasService;

@Controller
@ComponentScan("com.coffeshop.model")
public class ComidasController {
	
	@Autowired
	private ApplicationContext context;
	
	public String cardapio() {
		return "cardapio";
	}
	
	/* ****CADASTRAR***** */
	@GetMapping("/comida")
	public String formComidas(Model model) {
		model.addAttribute("comida", new Comidas());
		return "formComidas";
	}
	@PostMapping("/comida")
	public String postComida(@ModelAttribute Comidas comida, Model model) {
		ComidasService cs = context.getBean(ComidasService.class);
		cs.postComida(comida);
		List<Map<String, Object>> lista = cs.getComidas();
		model.addAttribute("comidas", lista);
		return "listaComidas";
	}
	
	/* ***VISUALIZAR UM*** */
	@GetMapping("/comida/{id}")
	public String getComida(@PathVariable("id") int id,
							Model model) {
		ComidasService cs = context.getBean(ComidasService.class);
		Map<String, Object> map = cs.getComida(id);
		model.addAttribute("nome", map.get("nome"));
		model.addAttribute("descricao", map.get("descricao"));
		model.addAttribute("preco", map.get("preco"));
		model.addAttribute("categoria", map.get("categoria"));
		model.addAttribute("id", id);
		return "detalheComida";
	}
	
	/* ***VISUALIZAR TODOS*** */
	@GetMapping("/comidas")
	public String getComidas(Model model) {
		ComidasService cs = context.getBean(ComidasService.class);
		List<Map<String, Object>> lista = cs.getComidas();
		model.addAttribute("comidas", lista);
		return "listaComidas";
	}
	
	/* ***DELETAR*** */
	@PostMapping("/apagar/comida/{id}")
	public String delComida(@PathVariable("id") int id) {
		ComidasService cs = context.getBean(ComidasService.class);
		cs.delComida(id);
		return "redirect:/comidas";
	}
	
	/* ***EDITAR*** */
	@GetMapping("/editar/comida/{id}")
	public String putComida(@PathVariable("id") int id, Model model) {
		ComidasService cs = context.getBean(ComidasService.class);
		Map<String, Object> registro = cs.getComida(id);
		Comidas comida = new Comidas(id, registro.get("nome").toString(), 
									registro.get("descricao").toString(),
									registro.get("categoria").toString(),
									registro.get("preco").toString());
		model.addAttribute("comida", comida);
		model.addAttribute("id", id);
		return "editarComida";
	}
	@PostMapping("/editar/comida/{id}")
	public String putComida(@PathVariable("id") int id, 
								Model model,
								@ModelAttribute Comidas comida) {
		ComidasService cs = context.getBean(ComidasService.class);
		cs.putComida(id, comida);
		return "redirect:/comidas";
	}
}
