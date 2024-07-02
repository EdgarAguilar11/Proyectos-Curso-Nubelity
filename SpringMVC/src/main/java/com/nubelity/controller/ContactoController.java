package com.nubelity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nubelity.dao.ContactoDao;
import com.nubelity.model.Contacto;

@Controller
public class ContactoController {
	@Autowired
	private ContactoDao contactoDao;
	
	@GetMapping("/")
	public String listarContactos(Model model) {
		model.addAttribute("lista", contactoDao.list());
		return "contactos";
	}
	
	@GetMapping("nuevoContacto")
	public String nuevoContacto(Model model) {
		model.addAttribute("command", new Contacto());
		return "contactoForm";
	}
	
	//se usa redirect para saltarse el resolvedor de vistas, si dejo la "/" va a buscar un jsp con ese nombre y no se ira a la raiz como lo necesito
	@PostMapping("salvarContacto")
	//los parametros llevan una posición específica en algunos casos
	public String salvarContacto(@Valid @ModelAttribute("command") Contacto contacto, Errors errors, Model model) {
		if(errors.hasErrors()) {
			System.out.println(errors.getAllErrors());
			//se le pasa el objeto con la información que había metido el usuario para ayudar que no deba rellenar nuevamente el formulario
//			model.addAttribute("command", contacto);
			return "contactoForm";
		}
		contactoDao.saveOrUpdate(contacto);
		return "redirect:/";
	}
	
	@GetMapping("editarContacto")
	//integer id se usa por inferencia para reemplazar la notacion @requestParam
	public String editarContacto(Integer id, Model model) {
		model.addAttribute("command", contactoDao.get(id));
		return "contactoForm";
	}
	
	@GetMapping("borrarContacto")
	public String borrarContacto(int id) {
		contactoDao.delete(id);
		return "redirect:/";
	}
}
