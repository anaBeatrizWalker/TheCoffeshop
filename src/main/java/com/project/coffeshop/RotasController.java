package com.project.coffeshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RotasController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/cardapio")
	public String cardapio() {
		return "cardapio";
	}
	
	@GetMapping("/loja")
	public String loja() {
		return "loja";
	}
	
	@GetMapping("/sobre")
	public String sobre() {
		return "sobre";
	}
	
	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}
}
