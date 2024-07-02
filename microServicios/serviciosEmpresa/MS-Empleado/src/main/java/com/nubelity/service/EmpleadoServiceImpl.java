package com.nubelity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nubelity.entity.Empleado;
import com.nubelity.error.EmpleadoNotFoundException;
import com.nubelity.repository.EmpleadoRepository;
import com.nubelity.vo.Departamento;
import com.nubelity.vo.EmpleadoRespuesta;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Empleado salvarEmpleado(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public EmpleadoRespuesta recuperarEmpleadoDepartamento(Long empleadoId) throws EmpleadoNotFoundException {
		EmpleadoRespuesta empleadoRespuesta = new EmpleadoRespuesta();
		Empleado empleado = empleadoRepository.findById(empleadoId)
				.orElseThrow(() -> new EmpleadoNotFoundException("Empleado no encontrado"));
		
		List<ServiceInstance> instance = discoveryClient.getInstances("DEPARTAMENTO-SERVICE");
		if(instance != null && instance.size() > 0) {
			ServiceInstance serviceInstance = instance.get(0);
			String uri = serviceInstance.getUri().toString();
			uri += "/departamentos/" + empleado.getDepartamentoId();
			
			Departamento departamento = restTemplate.getForObject(uri, Departamento.class);
			empleadoRespuesta.setMensaje("OK");
			empleadoRespuesta.setEmpleado(empleado);
			empleadoRespuesta.setDepartamento(departamento);			
		}
		
		return empleadoRespuesta;
	}

}
