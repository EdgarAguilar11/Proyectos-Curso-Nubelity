package com.nubelity.model.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nubelity.model.dao.TrabajadorDao;
import com.nubelity.model.entity.Trabajador;

@Repository
public class TrabajadorDaoImpl implements TrabajadorDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Trabajador> findAll() {
		TypedQuery<Trabajador> query = sessionFactory.getCurrentSession()
				.createQuery("FROM Trabajador");
		return query.getResultList();
	}

	@Override
	public void save(Trabajador trabajador) {
		sessionFactory.getCurrentSession().save(trabajador);
	}

}
