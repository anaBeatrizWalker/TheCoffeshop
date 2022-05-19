package com.coffeshop.cadastro;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.coffeshop.model.Bebidas;
import com.coffeshop.model.BebidasService;
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
	
	@GetMapping("/comidas")
	public String formComidas(Model model) {
		model.addAttribute("comida", new Comidas());
		return "formComidas";
	}
	
	@PostMapping("/comidas")
	public String comidasInserir(@ModelAttribute Comidas comida) {
		ComidasService cs = context.getBean(ComidasService.class);
		cs.inserirComida(comida);
		return "sucesso";
	}
}
