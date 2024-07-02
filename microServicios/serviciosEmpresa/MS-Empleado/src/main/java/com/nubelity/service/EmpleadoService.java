package com.nubelity.service;

import com.nubelity.entity.Empleado;
import com.nubelity.error.EmpleadoNotFoundException;
import com.nubelity.vo.EmpleadoRespuesta;

public interface EmpleadoService {
	Empleado salvarEmpleado(Empleado empleado);
	EmpleadoRespuesta recuperarEmpleadoDepartamento(Long empleadoId) throws EmpleadoNotFoundException;
}
