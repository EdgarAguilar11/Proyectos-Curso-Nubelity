package com.nubelity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nubelity.entity.Empleado;
import com.nubelity.error.EmpleadoNotFoundException;
import com.nubelity.service.EmpleadoService;
import com.nubelity.vo.EmpleadoRespuesta;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
	@Autowired
	private EmpleadoService empleadoService;
	
	@PostMapping("/")
	public Empleado salvarEmpleado(@RequestBody Empleado empleado) {
		return empleadoService.salvarEmpleado(empleado);
	}
	
	@GetMapping("/{id}")
	public EmpleadoRespuesta recuperarEmpleadoDepartamento(@PathVariable("id") Long empleadoId) throws EmpleadoNotFoundException {
		return empleadoService.recuperarEmpleadoDepartamento(empleadoId);
	}
}
