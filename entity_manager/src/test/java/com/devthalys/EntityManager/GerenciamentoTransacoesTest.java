package com.devthalys.EntityManager;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.devthalys.EntityManager.model.Produto;

/**
 * persist -> joga no banco apenas se tiver uma transacao
 */

public class GerenciamentoTransacoesTest {

	@Autowired
	private EntityManager em;

	@Test
	void abrirFecharCancelarTransacao() {

		try {

			regraNegocio();

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
	}

	private void regraNegocio() {

		Produto produto = em.find(Produto.class, 1);

		if (produto.getId() != null) {
			em.getTransaction().begin(); // inicia uma transacao
			em.getTransaction().commit(); // commita todas as alteracoes da transacao
		} else {
			em.getTransaction().rollback(); // cancela uma transacao
		}
	}
}
