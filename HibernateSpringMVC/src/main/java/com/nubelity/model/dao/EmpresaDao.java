package com.nubelity.model.dao;

import java.util.List;

import com.nubelity.model.entity.Empresa;

public interface EmpresaDao {
	List<Empresa> findAll();
	void save(Empresa empresa);
}
