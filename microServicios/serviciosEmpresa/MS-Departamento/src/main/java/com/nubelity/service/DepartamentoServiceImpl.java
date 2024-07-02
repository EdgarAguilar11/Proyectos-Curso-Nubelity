package com.nubelity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nubelity.entity.Departamento;
import com.nubelity.error.DepartamentoNotFoundException;
import com.nubelity.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Override
	public Departamento salvarDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	@Override
	public Departamento findDepartamentoById(Long departamentoId) throws DepartamentoNotFoundException{
		return departamentoRepository.findById(departamentoId)
				.orElseThrow(() -> new DepartamentoNotFoundException("Departamento no encontrado"));
	}

}
