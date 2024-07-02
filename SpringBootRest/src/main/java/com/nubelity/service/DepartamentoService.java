package com.nubelity.service;

import java.util.List;

import com.nubelity.entity.Departamento;
import com.nubelity.error.DepartamentoNotFoundException;

public interface DepartamentoService {
	Departamento saveDepartamento(Departamento departamento);
	List<Departamento> fetchDepartamentoList();
	Departamento fetchDepartamentoById(Long departamentoId) throws DepartamentoNotFoundException;
	List<Departamento> fetchDepartamentoByNombre(String departamentoNombre);
	Departamento updateDepartamento(Long departamentoId, Departamento departamento) throws DepartamentoNotFoundException;
	void deleteDepartamentoById(Long departamentoId) throws DepartamentoNotFoundException;
}
