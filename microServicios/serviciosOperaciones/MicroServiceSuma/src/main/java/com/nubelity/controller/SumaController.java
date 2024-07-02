package com.nubelity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.nubelity.model.Operaciones;

@Controller
public class SumaController {
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/")
	public String formulario() {
		return "captura";
	}
	
	@PostMapping("/suma")
	public String ejecutar(@RequestParam(value="num1") int num1, 
			@RequestParam(value="num2") int num2, Model model) {
		Operaciones operaciones = new Operaciones();
		operaciones.setNum1(num1);
		operaciones.setNum2(num2);
		operaciones.setSuma(num1 + num2);
		
		List<ServiceInstance> instance = discoveryClient.getInstances("Micro-service-multiplica");
		if(instance != null && instance.size() > 0) {
			ServiceInstance serviceInstance = instance.get(0);
			String uri = serviceInstance.getUri().toString();
			uri += "/multiplica";
			
			RestTemplate restTemplate = new RestTemplate();
			operaciones = restTemplate.postForObject(uri, operaciones, Operaciones.class);
		}
		model.addAttribute("suma",operaciones.getSuma());
		model.addAttribute("multiplicacion",operaciones.getMultiplicacion());
		model.addAttribute("division",operaciones.getDivision());
		
		return "resultado";
	}
}
