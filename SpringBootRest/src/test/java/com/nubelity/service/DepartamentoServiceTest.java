package com.nubelity.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nubelity.entity.Departamento;
import com.nubelity.error.DepartamentoNotFoundException;
import com.nubelity.repository.DepartamentoRepository;

@SpringBootTest
public class DepartamentoServiceTest {
	@Autowired
	private DepartamentoService departamentoService;
	
	//esta notación nos permite indicar a Spring que emule 
	//la clase del repositorio y por ende la ejecución sobre la BD
	@MockBean
	private DepartamentoRepository departamentoRepository;
	
	@BeforeEach
	void setup() throws Exception{
		Departamento departamento = new Departamento();
		departamento.setDepartamentoId(1L);
		departamento.setNombre("Depto1");
		departamento.setCodigo("C1");
		departamento.setDireccion("Direccion 1");
		//ayuda a emular la solicitud de metodos pertenecientes al repositorio
		Mockito.when(departamentoRepository.findById(1L))
		.thenReturn(Optional.of(departamento));
	}
	
	@Test
	public void cuandoDepartamentoNombreEncontrado() {
		String nombreDepto = "Depto2";
		try {
			Departamento departamento = departamentoService.fetchDepartamentoById(1L);
			assertEquals(nombreDepto, departamento.getNombre());
		} catch (DepartamentoNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
