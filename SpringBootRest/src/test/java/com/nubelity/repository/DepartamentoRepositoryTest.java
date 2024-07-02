package com.nubelity.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.nubelity.entity.Departamento;

@DataJpaTest
public class DepartamentoRepositoryTest {
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Autowired
	//clase que nos ayuda a hacer operaciones en la base de datos de 
	//manera temporal en comparación con el repository
	private TestEntityManager testEntityManager;
	
	//el 1L es para pedir el id "1" y la "L" es de Long
	@BeforeEach
	void setup() throws Exception{
		Departamento departamento = new Departamento();
		departamento.setNombre("Depto1");
		departamento.setCodigo("C1");
		departamento.setDireccion("Direccion 1");
		
		//metodo para que el dato solo persista mientras se realizan las pruebas
		testEntityManager.persist(departamento);
	}
	
	@Test
	public void cuandoFindByIdReturnDepartamento() {
		Departamento departamento = departamentoRepository.findById(1L).get();
		assertEquals(departamento.getNombre(), "Depto1");
	}
}
