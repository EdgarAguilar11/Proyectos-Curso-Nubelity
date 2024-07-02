package com.nubelity.service;

import com.nubelity.entity.Departamento;
import com.nubelity.error.DepartamentoNotFoundException;

public interface DepartamentoService {
	Departamento salvarDepartamento (Departamento departamento);
	Departamento findDepartamentoById(Long departamentoId) throws DepartamentoNotFoundException;
}
