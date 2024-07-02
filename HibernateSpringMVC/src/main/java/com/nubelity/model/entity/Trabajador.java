package com.nubelity.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//mapeo de un trabajador a la empresa a la cual trabaja con cardinalidad Muchos a Uno
//siendo la llave foranea empresa_ids
@Entity
public class Trabajador {
	@Id	//indica que es la llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 255, nullable = false)
	private String nombre;
	
	@Column(length = 255, nullable = false)
	private String apellido;
	
	@Column(length = 20, nullable = false, name = "tipo_trabajador")
	@Enumerated(EnumType.STRING)
	private TipoTrabajador tipoTrabajador = TipoTrabajador.DESARROLLADOR;
	
	@ManyToOne(targetEntity = Empresa.class)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public TipoTrabajador getTipoTrabajador() {
		return tipoTrabajador;
	}

	public void setTipoTrabajador(TipoTrabajador tipoTrabajador) {
		this.tipoTrabajador = tipoTrabajador;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
