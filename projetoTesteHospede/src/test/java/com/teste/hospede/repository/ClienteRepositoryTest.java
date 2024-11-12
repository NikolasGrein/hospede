package com.teste.hospede.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.teste.hospede.entity.Cliente;

@DataJpaTest
class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository ClienteRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		
		//Given / Arrange
		Cliente Cliente1 = new Cliente (null, "Alice","(00)0000-0000", "72364136", "49716414");
		//When /Act
		Cliente saveCliente = ClienteRepository.save(Cliente1);
		
		//Then /Assert
		assertNotNull(saveCliente);
		assertTrue(saveCliente.getId() > 0);
	}
	
	@DisplayName("Testando Get para todos Clientes")
	@Test
	void testGetAllRepository() {
		
		//Given / Arrange
		
		Cliente Cliente1 = new Cliente(null, "Pedro",
				"(00)0000-0000",
				"946205827",
				"184821047");
		
		Cliente Cliente2 = new Cliente(null, "Fernanda",
				"(00)0000-0000",
				"56721043",
				"15384067");
		
		ClienteRepository.save(Cliente1);
		ClienteRepository.save(Cliente2);
		
		List<Cliente> ClienteList = ClienteRepository.findAll();
		
		assertNotNull(ClienteList);
		assertEquals(2, ClienteList.size());
	}
	@DisplayName("Testando Get por ID")
	@Test
	void testGetById() {
		
		//Given / Arrange
		
		Cliente Cliente1 = new Cliente(null, "Luiza",
				"(00)0000-0000",
				"01784639",
				"56296719");
		
		ClienteRepository.save(Cliente1);
		
		//When / Act
		Cliente saveCliente = ClienteRepository.findById(Cliente1.getId()).get();
		
		//Then / Assert
		assertNotNull(saveCliente);
		assertEquals(Cliente1.getId(), saveCliente.getId());
		
	}
	@DisplayName("Testando Update")
	@Test
	void testUpdateCliente() {
		
		//Given / Arrange
		
		Cliente Cliente1 = new Cliente(null, "Guilherme",
				"(00)0000-0000",
				"81946582",
				"17495673");
		
		ClienteRepository.save(Cliente1);
		
		//When /Act
		
		Cliente saveCliente = ClienteRepository.findById(Cliente1.getId()).get();
		Cliente1.setNome("Leonardo");
		Cliente1.setTelefone("leonardo@gmail.com");
		
		Cliente updateCliente = ClienteRepository.save(saveCliente);
		
		//Then / Assert
		assertNotNull(updateCliente);
		assertEquals("Leonardo", updateCliente.getNome());
		assertEquals("leonardo@gmail.com", updateCliente.getTelefone());
	}
	@DisplayName("Testando Update")
	@Test
	void testDeleteCliente() {
		
		//Given / Arrange
		
		Cliente Cliente1 = new Cliente(null, "Julio Fernando",
				"(00)0000-0000",
				"739828574",
				"275019867");
		
		ClienteRepository.save(Cliente1);
		
		//When /Act
		ClienteRepository.deleteById(Cliente1.getId());
		
		Optional<Cliente> ClienteOptional = ClienteRepository.findById(Cliente1.getId());
		
		//Then /Assert
		
		assertTrue(ClienteOptional.isEmpty());
	}
}