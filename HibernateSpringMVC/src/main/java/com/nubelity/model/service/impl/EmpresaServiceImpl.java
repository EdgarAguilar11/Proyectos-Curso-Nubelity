package com.nubelity.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nubelity.model.dao.EmpresaDao;
import com.nubelity.model.entity.Empresa;
import com.nubelity.model.service.EmpresaService;

@Service	//importante para la inyeccion de codigo
public class EmpresaServiceImpl implements EmpresaService {
	
	@Autowired
	private EmpresaDao empresaDao;
	
	@Override
	@Transactional(readOnly = true)   //no se debe olvidar la parte transaccional
	public List<Empresa> findAll() {
		//todas las consultas deben ser de tipo transaccional por ello la notación Transactional
		return empresaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Empresa empresa) {
		empresaDao.save(empresa);
	}

}
