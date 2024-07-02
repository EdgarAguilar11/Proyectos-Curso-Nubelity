package com.nubelity.vo;

import com.nubelity.entity.Empleado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoRespuesta {
	private String mensaje;
	private Empleado empleado;
	private Departamento departamento;
}
