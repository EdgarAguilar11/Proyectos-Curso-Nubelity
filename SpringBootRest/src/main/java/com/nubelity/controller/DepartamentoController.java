package com.nubelity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nubelity.entity.Departamento;
import com.nubelity.error.DepartamentoNotFoundException;
import com.nubelity.service.DepartamentoService;

import jakarta.validation.Valid;

@RestController
public class DepartamentoController {
	@Autowired
	private DepartamentoService departamentoService;
	
	@PostMapping("/departamento")
	public Departamento salvar(@Valid @RequestBody Departamento departamento) {
		return departamentoService.saveDepartamento(departamento);
	}
	
	@GetMapping("/departamentos")
	public List<Departamento> recuperar(){
		return departamentoService.fetchDepartamentoList();
	}
	
	@GetMapping("/departamento/{id}")
	public Departamento recuperarPorId(@PathVariable("id") Long departamentoId) throws DepartamentoNotFoundException {
		return departamentoService.fetchDepartamentoById(departamentoId);
	}
	
	@GetMapping("/departamento/nombre/{nombre}")
	public List<Departamento> recuperarPorNombre(@PathVariable("nombre") String departamentoNombre){
		return departamentoService.fetchDepartamentoByNombre(departamentoNombre);
	}
	
	//se usa el verbo PUT para la actualización
	@PutMapping("/departamento/{id}")
	public Departamento actualizar(@PathVariable("id") Long departamentoId, @RequestBody Departamento departamento) throws DepartamentoNotFoundException {
		return departamentoService.updateDepartamento(departamentoId, departamento);
	}
	
	@DeleteMapping("/departamento/{id}")
	public String borrar(@PathVariable("id") Long departamentoId) throws DepartamentoNotFoundException {
		departamentoService.deleteDepartamentoById(departamentoId);
		return "Departamento eliminado exitosamente";
	}
}
