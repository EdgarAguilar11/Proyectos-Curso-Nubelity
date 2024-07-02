package com.nubelity.model.service;

import java.util.List;

import com.nubelity.model.entity.Empresa;

public interface EmpresaService {
	List<Empresa> findAll();
	void save(Empresa empresa);
}
