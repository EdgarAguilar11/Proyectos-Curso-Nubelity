package com.nubelity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long departamentoId;
	//en la versión de spring del proyecto no es necesario usar column ya que se coloca por default sino se coloca
	
	@NotBlank(message = "El nombre es obligatorio")
	String nombre;
	
	String direccion;
	String codigo;
}
