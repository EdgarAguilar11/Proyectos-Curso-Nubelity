package com.nubelity.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nubelity.util.JwtUtility;

@Service
public class UserService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Aqui se buscaría en la BD como en el proyecto anterior pero las lineas a continuación
		//se saltan ese paso por practicidad del ejemplo
		return new User("admin", "password", new ArrayList<>());
	}

}
