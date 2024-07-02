package com.nubelity.model.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nubelity.model.dao.EmpresaDao;
import com.nubelity.model.entity.Empresa;

//la notación le indica a Spring que existe y tiene operaciones con la base de datos, se coloca en los archivos de implementación
@Repository
public class EmpresaDaoImpl implements EmpresaDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Empresa> findAll() {
		//el nombre de la clase debe coincidir con el nombre de la clase de mapeo, si tiene mayusculas se debe respetar
		TypedQuery<Empresa> query = sessionFactory.getCurrentSession()
				.createQuery("FROM Empresa");
		return query.getResultList();
	}

	@Override
	public void save(Empresa empresa) {
		sessionFactory.getCurrentSession().save(empresa);
	}

}
