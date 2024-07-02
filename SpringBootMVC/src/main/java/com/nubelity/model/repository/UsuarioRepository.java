package com.nubelity.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nubelity.model.entity.Usuario;

//entidad para hacer consultas y el tipo de dato de la llave primaria
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}
