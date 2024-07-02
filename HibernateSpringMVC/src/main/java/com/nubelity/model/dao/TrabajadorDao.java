package com.nubelity.model.dao;

import java.util.List;

import com.nubelity.model.entity.Trabajador;

public interface TrabajadorDao {
	List<Trabajador> findAll();
	void save(Trabajador trabajador);
}
