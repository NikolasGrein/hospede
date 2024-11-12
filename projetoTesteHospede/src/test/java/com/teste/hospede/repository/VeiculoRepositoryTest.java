package com.test.projeto.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.projeto.entities.Veiculos;
import com.projeto.repository.VeiculosRepository;



@DataJpaTest
class VeiculosRepositoryTest {

	@Autowired
	private VeiculosRepository VeiculosRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		
		//Given / Arrange
		Veiculos Veiculos1 = new Veiculos (null, "Otávio",
											"15996373766",
	                                        1,
	                                        "571649105");
		//When /Act
		Veiculos saveVeiculos = VeiculosRepository.save(Veiculos1);
		
		//Then /Assert
		assertNotNull(saveVeiculos);
		assertTrue(saveVeiculos.getId() > 0);
	}
	
	@DisplayName("Testando Get para todos Veiculoss")
	@Test
	void testGetAllRepository() {
		
		//Given / Arrange
		
		Veiculos Veiculos1 = new Veiculos(null, "Julia Maria",
				"julia@gmail.com",
				1,
				"46302556805");
		
		Veiculos Veiculos2 = new Veiculos(null, "Julio Fernando",
				"julio@gmail.com",
				1,
				"46302556805");
		
		VeiculosRepository.save(Veiculos1);
		VeiculosRepository.save(Veiculos2);
		
		List<Veiculos> VeiculosList = VeiculosRepository.findAll();
		
		assertNotNull(VeiculosList);
		assertEquals(2, VeiculosList.size());
	}
	@DisplayName("Testando Get por ID")
	@Test
	void testGetById() {
		
		//Given / Arrange
		
		Veiculos Veiculos1 = new Veiculos(null, "Julio Fernando",
				"julio@gmail.com",
				1,
				"46302556805");
		
		VeiculosRepository.save(Veiculos1);
		
		//When / Act
		Veiculos saveVeiculos = VeiculosRepository.findById(Veiculos1.getId()).get();
		
		//Then / Assert
		assertNotNull(saveVeiculos);
		assertEquals(Veiculos1.getId(), saveVeiculos.getId());
		
	}
	@DisplayName("Testando Update")
	@Test
	void testUpdateVeiculos() {
		
		//Given / Arrange
		
		Veiculos Veiculos1 = new Veiculos(null, "Julio Fernando",
				"julio@gmail.com",
				1,
				"46302556805");
		
		VeiculosRepository.save(Veiculos1);
		
		//When /Act
		
		Veiculos saveVeiculos = VeiculosRepository.findById(Veiculos1.getId()).get();
		Veiculos1.setMarca("Leonardo");
		Veiculos1.setModelo("leonardo@gmail.com");
		
		Veiculos updateVeiculos = VeiculosRepository.save(saveVeiculos);
		
		//Then / Assert
		assertNotNull(updateVeiculos);
		assertEquals("Leonardo", updateVeiculos.getMarca());
		assertEquals("leonardo@gmail.com", updateVeiculos.getModelo());
	}
	@DisplayName("Testando Update")
	@Test
	void testDeleteVeiculos() {
		
		//Given / Arrange
		
		Veiculos Veiculos1 = new Veiculos(null, "Julio Fernando",
				"julio@gmail.com",
				1,
				"46302556805");
		
		VeiculosRepository.save(Veiculos1);
		
		//When /Act
		VeiculosRepository.deleteById(Veiculos1.getId());
		
		Optional<Veiculos> VeiculosOptional = VeiculosRepository.findById(Veiculos1.getId());
		
		//Then /Assert
		
		assertTrue(VeiculosOptional.isEmpty());
	}
}