package com.nubelity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HolaController {
	@GetMapping("/hola")
	public String hola(@RequestParam String nombre, @RequestParam String apellido, Model model) {
		String saludo = "Hola " + nombre + " " + apellido + "!";
		System.out.println(saludo);
		
		model.addAttribute("bienvenida", saludo);
		return "hola";
	}
}
