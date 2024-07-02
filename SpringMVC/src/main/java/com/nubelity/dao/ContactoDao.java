package com.nubelity.dao;

import java.util.List;

import com.nubelity.model.Contacto;

public interface ContactoDao {
	List<Contacto> list();
	void saveOrUpdate(Contacto contacto);
	Contacto get(int contactoId);
	void delete(int contactoId);
}
