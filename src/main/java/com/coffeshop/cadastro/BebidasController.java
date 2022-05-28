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
import com.coffeshop.model.Bebidas;
import com.coffeshop.model.BebidasService;

@Controller
@ComponentScan("com.coffeshop.model")
public class BebidasController {
	
	@Autowired
	private ApplicationContext context;
	
	public String cardapio() {
		return "cardapio";
	}
	
	/* ****CADASTRAR***** */
	@GetMapping("/bebida")
	public String formBebidas(Model model) {
		model.addAttribute("bebida", new Bebidas());
		return "formBebidas";
	}
	@PostMapping("/bebida")
	public String postBebidas(@ModelAttribute Bebidas bebida, Model model) {
		BebidasService bs = context.getBean(BebidasService.class);
		bs.postBebida(bebida);
		List<Map<String, Object>> lista = bs.getBebidas();
		model.addAttribute("bebidas", lista);
		return "listaBebidas";
	}
	
	/* ***VISUALIZAR UMA*** */
	@GetMapping("/bebida/{id}")
	public String getBebida(@PathVariable("id") int id,
							Model model) {
		BebidasService bs = context.getBean(BebidasService.class);
		Map<String, Object> map = bs.getBebida(id);
		model.addAttribute("nome", map.get("nome"));
		model.addAttribute("descricao", map.get("descricao"));
		model.addAttribute("preco", map.get("preco"));
		model.addAttribute("categoria", map.get("categoria"));
		model.addAttribute("tamanho", map.get("tamanho"));
		model.addAttribute("id", id);
		return "detalheBebida";
	}
	
	/* ***VISUALIZAR TODAS*** */
	@GetMapping("/bebidas")
	public String getBebidas(Model model) {
		BebidasService bss = context.getBean(BebidasService.class);
		List<Map<String, Object>> lista = bss.getBebidas();
		model.addAttribute("bebidas", lista);
		return "listaBebidas";
	}
	
	/* ***DELETAR*** */
	@PostMapping("/apagar/bebida/{id}")
	public String delBebida(@PathVariable("id") int id) {
		BebidasService bs = context.getBean(BebidasService.class);
		bs.delBebidas(id);
		return "redirect:/bebidas";
	}
	
	/* ***EDITAR*** */
	@GetMapping("/editar/bebida/{id}")
	public String putBebida(@PathVariable("id") int id, Model model) {
		BebidasService bs = context.getBean(BebidasService.class);
		Map<String, Object> registro = bs.getBebida(id);
		Bebidas bebida = new Bebidas(id, registro.get("nome").toString(), 
											registro.get("descricao").toString(), 
											registro.get("categoria").toString(), 
											registro.get("preco").toString(), 
											registro.get("tamanho").toString());
		model.addAttribute("bebida", bebida);
		model.addAttribute("id", id);
		return "editarBebida";
	}
	@PostMapping("/editar/bebida/{id}")
	public String updBebida(@PathVariable("id") int id, 
								Model model,
								@ModelAttribute Bebidas bebida) {
		BebidasService bs = context.getBean(BebidasService.class);
		bs.updBebidas(id, bebida);
		return "redirect:/bebidas";
	}
}
