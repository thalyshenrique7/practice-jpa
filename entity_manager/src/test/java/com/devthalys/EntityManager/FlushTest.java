package com.devthalys.EntityManager;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.devthalys.EntityManager.model.Produto;

public class FlushTest {

	@Autowired
	private EntityManager em;

	@Test
	void chamarFlush() {

		try {
			Produto produto = em.find(Produto.class, 1);

			if (produto.getId() != null) {
				em.flush(); // obriga o jpa a pegar tudo que esta em memoria e sincronizar com o banco
				em.getTransaction().commit();
			} else {
				em.getTransaction().rollback();
			}

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
	}
}
