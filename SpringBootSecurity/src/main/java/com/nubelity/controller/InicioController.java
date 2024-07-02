package com.nubelity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class InicioController {
	//Le llamamos endpoints a las peticiones definidas en el controlador
	@GetMapping("/regular")
	public String regular() {
		return "Ruta de inicio general";
	}
	
	@GetMapping("/admin")
	public String admin(){
		return "Ruta de administrador";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
