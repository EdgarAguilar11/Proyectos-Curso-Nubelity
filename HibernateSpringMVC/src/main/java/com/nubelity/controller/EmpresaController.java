package com.nubelity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nubelity.model.entity.Empresa;
import com.nubelity.model.entity.TipoTrabajador;
import com.nubelity.model.entity.Trabajador;
import com.nubelity.model.service.EmpresaService;
import com.nubelity.model.service.TrabajadorService;

@Controller
public class EmpresaController {
	@Autowired	//solo afecta a un statement. Una variable, un metodo, una clase son ejemplo de ello.
	private EmpresaService empresaService;
	
	@Autowired
	private TrabajadorService trabajadorService;
	
	@GetMapping("/empresas")
	public String empresas(Model model) {
		model.addAttribute("empresas", empresaService.findAll());
		return "empresas";
	}
	
	@GetMapping("/agregarEmpresa")
	public String agregarEmpresa(Model model) {
		model.addAttribute("command",new Empresa());
		return "empresaForm";
	}
	
	@PostMapping("/agregarEmpresa")
	public String agregarEmpresa(Empresa empresa) {
		empresaService.save(empresa);
		return "redirect:empresas";
	}
	
	@GetMapping("/trabajadores")
	public String trabajadores(Model model) {
		model.addAttribute("trabajadores", trabajadorService.findAll());
		return "trabajadores";
	}
	
	@GetMapping("/agregarTrabajador")
	public String agregarTrabajador(Model model) {
		model.addAttribute("command", new Trabajador());
		model.addAttribute("empresas", empresaService.findAll());
		model.addAttribute("tiposTrabajador", TipoTrabajador.values());
		return "trabajadorForm";
	}
	
	@PostMapping("/agregarTrabajador")
	public String agregarTrabajador(Trabajador trabajador) {
		trabajadorService.save(trabajador);
		return "redirect:trabajadores";
	}
}
