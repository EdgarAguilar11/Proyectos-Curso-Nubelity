package com.nubelity.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaControlller {
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@GetMapping("/")
	public String hola() {
		return welcomeMessage;
	}
}
