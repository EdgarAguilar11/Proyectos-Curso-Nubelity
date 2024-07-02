package com.nubelity.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nubelity.model.Operaciones;

@RestController
public class DivideController {
	//Endpoint
	@PostMapping("/divide")
	public Operaciones divide(@RequestBody Operaciones operaciones) {
		operaciones.setDivision(operaciones.getMultiplicacion()/operaciones.getNum1());
		return operaciones;
	}

}
