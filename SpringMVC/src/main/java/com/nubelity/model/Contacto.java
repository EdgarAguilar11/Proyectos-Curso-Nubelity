package com.nubelity.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Contacto {
	private int id;
	
	@NotBlank(message = "El Nombre no puede estar vacio")
	private String nombre;
	
	@NotBlank(message = "El Email no puede estar vacio")
	@Email(message = "El Email debe seguir el formato correcto")
	private String email;
	
	private String direccion;
	private String telefono;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
