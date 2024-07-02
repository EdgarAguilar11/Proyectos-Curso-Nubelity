package com.nubelity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nubelity.entity.Departamento;
import com.nubelity.error.DepartamentoNotFoundException;
import com.nubelity.service.DepartamentoService;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
	@Autowired
	private DepartamentoService departamentoService;
	
	@PostMapping("/")
	private Departamento salvarDepartamento(@RequestBody Departamento departamento) {
		return departamentoService.salvarDepartamento(departamento);
	}
	
	@GetMapping("/{id}")
	public Departamento buscarDepartamento(@PathVariable("id") Long departamentoId) throws DepartamentoNotFoundException {
		return departamentoService.findDepartamentoById(departamentoId);
	}
}
