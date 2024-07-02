package com.nubelity.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nubelity.model.entity.Usuario;
import com.nubelity.model.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> fetchUsuarioList() {
		return usuarioRepository.findAll();		
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		//la verificación en base al id se realiza por parte de jpa por lo que el metodo save guarda y actualiza el registro indicado
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario findById(Long usuarioId) {
		//optional hace referencia a un objeto que puede o no estar (para este ejemplo debido a que se solicita un id que no exista) 
		//por lo que si llega vacio 
		//se le implementa una excepción que haga referencia a la misma en lugar de regresar un null ya que es una mejor práctica
		return usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new IllegalArgumentException("Usuario inválido: " + usuarioId));
	}

	@Override
	public void delete(Long usuarioId) {
		usuarioRepository.deleteById(usuarioId);
	}

}
