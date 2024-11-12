package com.teste.hospede.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuartoTest {

	private Quarto quarto;
	
	@BeforeEach
	void setUp () {
		//Arrange
		quarto = new Quarto(1L,"1", "Reservado");
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		quarto.setId(2L);
		//Assert
		assertEquals(2L, quarto.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo num")
	void testNum() {
		//Act
		quarto.setNum("2");
		//Assert
		assertEquals("2", quarto.getNum());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo tipo")
	void testTipo() {
		//Act
		quarto.setTipo("Aberto para reserva");
		//Assert
		assertEquals("Aberto para reserva", quarto.getTipo());
	}

	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstrutorAll() {
		//Act
		Quarto novoQuarto = new Quarto(3L, "3", "Reservado");
		//Assertion
		assertAll("novoQuarto",
				()-> assertEquals (3L, novoQuarto.getId()),
				()-> assertEquals ("3", novoQuarto.getNum()),
				()-> assertEquals ("Reservado", novoQuarto.getTipo()));
	}

}
