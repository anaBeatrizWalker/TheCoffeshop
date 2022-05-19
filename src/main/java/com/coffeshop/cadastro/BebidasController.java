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

@Controller
@ComponentScan("com.coffeshop.model")
public class BebidasController {
	
	@Autowired
	private ApplicationContext context;
	
	public String cardapio() {
		return "cardapio";
	}
	
	@GetMapping("/bebidas")
	public String formBebidas(Model model) {
		model.addAttribute("bebida", new Bebidas());
		return "formBebidas";
	}
	
	@PostMapping("/bebidas")
	public String bebidasInserir(@ModelAttribute Bebidas bebida) {
		BebidasService bs = context.getBean(BebidasService.class);
		bs.inserirBebida(bebida);
		return "sucesso";
	}
}
