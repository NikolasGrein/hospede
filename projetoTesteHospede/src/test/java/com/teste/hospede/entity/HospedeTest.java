package com.teste.hospede.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HospedeTest {

	private Hospede hospede;
	
	@BeforeEach
	void setUp () {
		//Arrange
		hospede = new Hospede(1L,"Everton", "evertonGames@gmail.com", "(00)0000-0000");
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		hospede.setId(2L);
		//Assert
		assertEquals(2L, hospede.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		//Act
		hospede.setNome("Maria");
		//Assert
		assertEquals("Maria", hospede.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo email")
	void testEmail() {
		//Act
		hospede.setEmail("maria@gmail.com");
		//Assert
		assertEquals("maria@gmail.com", hospede.getEmail());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo telefone")
	void testTelefone() {
		//Act
		hospede.setTelefone("(11)1111-1111");
		//Assert
		assertEquals("(11)1111-1111", hospede.getTelefone());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstrutorAll() {
		//Act
		Hospede novoHospede = new Hospede(3L, "Olivia", "olivia@gmail.com", "(33)3333-3333");
		//Assertion
		assertAll("novoHospede",
				()-> assertEquals (3L, novoHospede.getId()),
				()-> assertEquals ("Olivia", novoHospede.getNome()),
				()-> assertEquals ("olivia@gmail.com", novoHospede.getEmail()),
				()-> assertEquals ("(33)3333-3333", novoHospede.getTelefone()));
	}

}
