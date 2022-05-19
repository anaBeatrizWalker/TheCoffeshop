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
import com.coffeshop.model.Cafes;
import com.coffeshop.model.CafesService;
import com.coffeshop.model.Comidas;
import com.coffeshop.model.ComidasService;

@Controller
@ComponentScan("com.coffeshop.model")
public class CafesController {
	
	@Autowired
	private ApplicationContext context;
	
	public String cardapio() {
		return "cardapio";
	}
	
	@GetMapping("/cafes")
	public String formCafe(Model model) {
		model.addAttribute("cafe", new Cafes());
		return "formCafe";
	}
	
	@PostMapping("/cafes")
	public String cafesInserir(@ModelAttribute Cafes cafe) {
		CafesService cas = context.getBean(CafesService.class);
		cas.inserirCafe(cafe);
		return "sucesso";
	}
}
