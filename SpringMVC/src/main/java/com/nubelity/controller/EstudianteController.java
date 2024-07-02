package com.nubelity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nubelity.model.Estudiante;

@Controller
public class EstudianteController {
	@GetMapping("/estudiante")
	public String formulario(Model model) {
		//"command" es el valor por defecto para los objetos cuando es uno
		model.addAttribute("command", new Estudiante());
		return null;
	}
	
	@PostMapping("/estudiante")
	public String agregarEstudiante(@ModelAttribute("command") Estudiante estudiante, Model model) {
		System.out.println("Id: " + estudiante.getId());
		System.out.println("Nombre: " + estudiante.getNombre());
		System.out.println("Edad: " + estudiante.getEdad());
		
		model.addAttribute("estudiante", estudiante);
		return "estudianteRegistrado";
	}
}
