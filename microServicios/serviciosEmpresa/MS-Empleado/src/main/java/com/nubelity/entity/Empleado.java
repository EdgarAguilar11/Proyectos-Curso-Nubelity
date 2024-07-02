package com.nubelity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empleadoId;
	private String nombre;
	private String apellido;
	private String email;
	private Long departamentoId;
}
