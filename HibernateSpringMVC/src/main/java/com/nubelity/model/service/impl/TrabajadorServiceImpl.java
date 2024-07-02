package com.nubelity.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nubelity.model.dao.TrabajadorDao;
import com.nubelity.model.entity.Trabajador;
import com.nubelity.model.service.TrabajadorService;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {
	
	@Autowired
	private TrabajadorDao trabajadorDao; 

	@Override
	@Transactional(readOnly = true)
	public List<Trabajador> findAll() {
		return trabajadorDao.findAll();
	}

	@Override
	@Transactional
	public void save(Trabajador trabajador) {
		trabajadorDao.save(trabajador);
	}

}
