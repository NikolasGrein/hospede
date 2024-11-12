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

import com.teste.hospede.entity.Produto;

	@DataJpaTest
	class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository ProdutoRepository;

	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {

		// Given / Arrange
		Produto Produto1 = new Produto(null, "Otávio", 2);
		// When /Act
		Produto saveProduto = ProdutoRepository.save(Produto1);

		// Then /Assert
		assertNotNull(saveProduto);
		assertTrue(saveProduto.getId() > 0);
	}

	@DisplayName("Testando Get para todos Produtos")
	@Test
	void testGetAllRepository() {

		// Given / Arrange

		Produto Produto1 = new Produto(null, "Julia Maria", 2);

		Produto Produto2 = new Produto(null, "Julio Fernando", 2);

		ProdutoRepository.save(Produto1);
		ProdutoRepository.save(Produto2);

		List<Produto> ProdutoList = ProdutoRepository.findAll();

		assertNotNull(ProdutoList);
		assertEquals(2, ProdutoList.size());
	}

	@DisplayName("Testando Get por ID")
	@Test
	void testGetById() {

		// Given / Arrange

		Produto Produto1 = new Produto(null, "Julio Fernando", 2);

		ProdutoRepository.save(Produto1);

		// When / Act
		Produto saveProduto = ProdutoRepository.findById(Produto1.getId()).get();

		// Then / Assert
		assertNotNull(saveProduto);
		assertEquals(Produto1.getId(), saveProduto.getId());

	}

	@DisplayName("Testando Update")
	@Test
	void testUpdateProduto() {

		// Given / Arrange

		Produto Produto1 = new Produto(null, "Julio Fernando", 2);

		ProdutoRepository.save(Produto1);

		// When /Act

		Produto saveProduto = ProdutoRepository.findById(Produto1.getId()).get();
		Produto1.setNome("Leonardo");
		Produto1.setPreco(2);

		Produto updateProduto = ProdutoRepository.save(saveProduto);

		// Then / Assert
		assertNotNull(updateProduto);
		assertEquals("Leonardo", updateProduto.getNome());
		assertEquals("leonardo@gmail.com", updateProduto.getPreco());
	}

	@DisplayName("Testando Update")
	@Test
	void testDeleteProduto() {

		// Given / Arrange

		Produto Produto1 = new Produto(null, "Julio Fernando", 2);

		ProdutoRepository.save(Produto1);

		// When /Act
		ProdutoRepository.deleteById(Produto1.getId());

		Optional<Produto> ProdutoOptional = ProdutoRepository.findById(Produto1.getId());

		// Then /Assert

		assertTrue(ProdutoOptional.isEmpty());
	}
}