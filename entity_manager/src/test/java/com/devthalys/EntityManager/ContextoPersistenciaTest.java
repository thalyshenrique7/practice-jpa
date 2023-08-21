package com.devthalys.EntityManager;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.devthalys.EntityManager.model.Produto;

public class ContextoPersistenciaTest {

	@Autowired
	private EntityManager em;

	@Test
	public void usarContextoPersistencia() {
		
		// dirty checking --> jpa checa de houve alteracao no objeto gerenciado

		em.getTransaction().begin();

		Produto produto = em.find(Produto.class, 1);
		produto.setPreco(100.00);

		Produto produto2 = new Produto();
		produto2.setNome("Java");
		em.persist(produto2);

		// aqui nao ha dirty checking, pois o objeto é novo
		Produto produto3 = new Produto();
		produto3.setNome("JPA");
		em.merge(produto3);

		em.flush();

		// jpa fica "ouvindo/esperando" alteracoes (dirty checking) e executa o update
		produto2.setPreco(200.00);

		em.getTransaction().commit();

	}
}
