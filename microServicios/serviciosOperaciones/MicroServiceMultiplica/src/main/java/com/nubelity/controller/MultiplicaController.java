package com.nubelity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nubelity.model.Operaciones;

@RestController
public class MultiplicaController {
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@PostMapping("/multiplica")
	public Operaciones multiplica(@RequestBody Operaciones operaciones) {
		operaciones.setMultiplicacion(operaciones.getSuma() * operaciones.getNum2());
		List<ServiceInstance> instance = discoveryClient.getInstances("MICRO-SERVICE-DIVIDE");
		if(instance != null && instance.size() > 0) {
			ServiceInstance serviceInstance = instance.get(0);
			String uri = serviceInstance.getUri().toString();
			uri += "/divide";
			
			RestTemplate restTemplate = new RestTemplate();
			operaciones = restTemplate.postForObject(uri, operaciones, Operaciones.class);
		}
		
		return operaciones;
	}

}
