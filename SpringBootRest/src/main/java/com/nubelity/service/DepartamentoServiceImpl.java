package com.nubelity.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nubelity.entity.Departamento;
import com.nubelity.repository.DepartamentoRepository;
import com.nubelity.error.DepartamentoNotFoundException;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Override
	public Departamento saveDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	@Override
	public List<Departamento> fetchDepartamentoList() {
		return departamentoRepository.findAll();
	}

	@Override
	public Departamento fetchDepartamentoById(Long departamentoId) throws DepartamentoNotFoundException{
		return departamentoRepository.findById(departamentoId)
				.orElseThrow(() -> new DepartamentoNotFoundException("Departamento no disponible"));
	}

	@Override
	public List<Departamento> fetchDepartamentoByNombre(String departamentoNombre) {
		return departamentoRepository.findByNombre(departamentoNombre);
	}

	@Override
	public Departamento updateDepartamento(Long departamentoId, Departamento departamento) throws DepartamentoNotFoundException {
		Departamento depDB = departamentoRepository.findById(departamentoId)
				.orElseThrow(() -> new DepartamentoNotFoundException("Departamento no disponible"));
		
		if(Objects.nonNull(departamento.getNombre()) && !"".equalsIgnoreCase(departamento.getNombre()))
			depDB.setNombre(departamento.getNombre());
		if(Objects.nonNull(departamento.getDireccion()) && !"".equalsIgnoreCase(departamento.getDireccion()))
			depDB.setDireccion(departamento.getDireccion());
		if(Objects.nonNull(departamento.getCodigo()) && !"".equalsIgnoreCase(departamento.getCodigo()))
			depDB.setCodigo(departamento.getCodigo());
		
		return departamentoRepository.save(depDB);
	}

	@Override
	public void deleteDepartamentoById(Long departamentoId) throws DepartamentoNotFoundException {
		if(departamentoRepository.existsById(departamentoId)) {
			departamentoRepository.deleteById(departamentoId);			
		}else {
			throw new DepartamentoNotFoundException("Departamento no disponible");
		}
	}
}
