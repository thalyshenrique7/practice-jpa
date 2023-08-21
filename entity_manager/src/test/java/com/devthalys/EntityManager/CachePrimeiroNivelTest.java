package com.devthalys.EntityManager;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.devthalys.EntityManager.model.Produto;

@SpringBootTest
class CachePrimeiroNivelTest {

	@Autowired
	private EntityManager em;

	@Test
	void verificarCache() {

		Produto produto = em.find(Produto.class, 1L);
		System.out.println(produto.getNome());

		System.out.println("\n-------------------------------");

		Produto mesmoProduto = em.find(Produto.class, produto.getId());
		System.out.println(mesmoProduto.getNome());
	}

}
