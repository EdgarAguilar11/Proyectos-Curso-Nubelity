package com.nubelity.model.service;

import java.util.List;

import com.nubelity.model.entity.Trabajador;

public interface TrabajadorService {
	List<Trabajador> findAll();
	void save(Trabajador trabajador);
}
