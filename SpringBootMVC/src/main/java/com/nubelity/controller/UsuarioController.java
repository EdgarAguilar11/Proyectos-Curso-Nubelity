package com.nubelity.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nubelity.model.entity.Usuario;
import com.nubelity.model.service.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/listado")
	public String listadoUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioService.fetchUsuarioList());
		return "usuarios";
	}
	
	@GetMapping("/registro")
	public String registroForm(Model model) {
		List<String> listaProfesiones = Arrays.asList("Desarrollador", "Tester", "Arquitecto");
		//ya no es necesario el command basico para jsp sino podemos usar un nombre mas representativo
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("listaProfesiones", listaProfesiones);
		return "usuarioForm";
	}
	
	@PostMapping("/registro")
	public String registroUsuario(Usuario usuario) {
		usuarioService.saveUsuario(usuario);
		return "usuarioExito";
	}
	
	@GetMapping("/actualizar/{id}")
	public String actualizarForm(@PathVariable(value = "id") Long usuarioId, Model model) {
		List<String> listaProfesiones = Arrays.asList("Desarrollador", "Tester", "Arquitecto");
		model.addAttribute("usuario", usuarioService.findById(usuarioId));
		model.addAttribute("listaProfesiones", listaProfesiones);
		return "usuarioForm";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable(value = "id") Long usuarioId, Model model) {
		usuarioService.delete(usuarioId);
		return "redirect:/listado";
	}
}
