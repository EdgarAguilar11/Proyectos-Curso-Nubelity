package com.nubelity.model.service;

import java.util.List;

import com.nubelity.model.entity.Usuario;

public interface UsuarioService {
	List<Usuario> fetchUsuarioList();
	Usuario saveUsuario(Usuario usuario);
	Usuario findById(Long usuarioId);
	void delete(Long usuarioId);
}
