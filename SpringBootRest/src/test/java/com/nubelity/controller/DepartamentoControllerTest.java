package com.nubelity.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.nubelity.entity.Departamento;
import com.nubelity.service.DepartamentoService;

@WebMvcTest(DepartamentoController.class)
public class DepartamentoControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartamentoService departamentoService;
	
	private Departamento departamento;
	
	@BeforeEach
	void setup() throws Exception{
		departamento = new Departamento(1L, "Depto1", "Dirección de Depto1", "DP-001");
	}
	
	@Test
	void testFetchDepartamentoById() throws Exception {
		Mockito.when(departamentoService.fetchDepartamentoById(1L))
		.thenReturn(departamento);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/departamento/1")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.nombre").value(departamento.getNombre()));
	}
	
	@Test
	void testSalvarDepartamento() throws Exception {
		Departamento entrada = new Departamento();
		entrada.setNombre("Depto1");
		entrada.setDireccion("Dirección de Depto1");
		entrada.setCodigo("DP-001");
		
		Mockito.when(departamentoService.saveDepartamento(entrada))
		.thenReturn(departamento);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/departamento")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{"
						+ "\"nombre\": \"Depto1\", \n"
						+ "\"direccion\": \"Dirección de Depto1\", \n"
						+ "\"codigo\": \"DP-001\" \n"
						+ "}"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
