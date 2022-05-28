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
import com.coffeshop.model.Cafes;
import com.coffeshop.model.CafesService;

@Controller
@ComponentScan("com.coffeshop.model")
public class CafesController {
	
	@Autowired
	private ApplicationContext context;
	
	public String cardapio() {
		return "cardapio";
	}
	
	/* ****CADASTRAR***** */
	@GetMapping("/cafe")
	public String formCafe(Model model) {
		model.addAttribute("cafe", new Cafes());
		return "formCafe";
	}
	@PostMapping("/cafe")
	public String postCafe(@ModelAttribute Cafes cafe, Model model) {
		CafesService cas = context.getBean(CafesService.class);
		cas.postCafe(cafe);
		List<Map<String, Object>> lista = cas.getCafes();
		model.addAttribute("cafes", lista);
		return "listaCafes";
	}
	
	/* ***VISUALIZAR UM*** */
	@GetMapping("/cafe/{id}")
	public String getCafe(@PathVariable("id") int id,
							Model model) {
		CafesService cas = context.getBean(CafesService.class);
		Map<String, Object> map = cas.getCafe(id);
		model.addAttribute("nome", map.get("nome"));
		model.addAttribute("descricao", map.get("descricao"));
		model.addAttribute("fornecedor", map.get("fornecedor"));
		model.addAttribute("preco", map.get("preco"));
		model.addAttribute("gramas", map.get("gramas"));
		model.addAttribute("id", id);
		return "detalheCafe";
	}
	
	/* ***VISUALIZAR TODOS*** */
	@GetMapping("/cafes")
	public String getCafes(Model model) {
		CafesService cas = context.getBean(CafesService.class);
		List<Map<String, Object>> lista = cas.getCafes();
		model.addAttribute("cafes", lista);
		return "listaCafes";
	}
	
	/* ***DELETAR*** */
	@PostMapping("/apagar/cafe/{id}")
	public String delCafe(@PathVariable("id") int id) {
		CafesService cas = context.getBean(CafesService.class);
		cas.delCafes(id);
		return "redirect:/cafes";
	}
	
	/* ***EDITAR*** */
	@GetMapping("/editar/cafe/{id}")
	public String putCafe(@PathVariable("id") int id, Model model) {
		CafesService cas = context.getBean(CafesService.class);
		Map<String, Object> registro = cas.getCafe(id);
		Cafes cafe = new Cafes(id, registro.get("nome").toString(), 
									registro.get("descricao").toString(), 
									registro.get("fornecedor").toString(), 
									registro.get("preco").toString(), 
									registro.get("gramas").toString());
		model.addAttribute("cafe", cafe);
		model.addAttribute("id", id);
		return "editarCafe";
	}
	@PostMapping("/editar/cafe/{id}")
	public String updCafe(@PathVariable("id") int id, 
								Model model,
								@ModelAttribute Cafes cafe) {
		CafesService cas = context.getBean(CafesService.class);
		cas.updCafes(id, cafe);
		return "redirect:/cafes";
	}
}
