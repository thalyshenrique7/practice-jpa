package com.devthalys.EntityManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.devthalys.EntityManager.model.Produto;

public class InserindoDadoComMergeTest {

	@Autowired
	private EntityManager em;

	@Test
	public void atualizaComMerge() {

		Produto produtoASerModificado = em.find(Produto.class, 1);

		produtoASerModificado.setId(1L);
		produtoASerModificado.setNome("Hibernate");
		produtoASerModificado.setPreco(250.00);

		em.getTransaction().begin();

		em.merge(produtoASerModificado); // Hibernate verifica se objeto já existe, caso tenha, faz o update

		em.getTransaction().commit();

		em.clear(); // limpa os dados em memória

		// sem o clear o entityManager irá buscar os dados do produto em memória
		// com o clear busca da base de dados
		Produto produtoVerificado = em.find(Produto.class, 1);

		assertNotNull(produtoVerificado);
	}

	@Test
	public void insereDadoComMerge() {

		Produto produtoNovo = new Produto();

		produtoNovo.setId(4L);
		produtoNovo.setNome("Spring Data");
		produtoNovo.setPreco(250.00);
		
		em.getTransaction().begin();

		em.merge(produtoNovo); // Hibernate verifica se objeto já existe, caso não, faz a inserção/persist

		em.getTransaction().commit();

		em.clear();

		Produto produtoVerificado = em.find(Produto.class, 4);

		assertNotNull(produtoVerificado);
	}
	
	public void diferencaPersistMerge() {
			
		/*
		 * Persist = apenas persistir
		 * Merge = atualizar e persistir
		 * 
		 * Os dois fazem com que a instancia seja gerenciada, porem o merge faz a copia e a copia que é gerenciada
		 */
	}
	
	public void impedeOperacaoComDetach() {
		
		Produto produtoNovo = new Produto();

		produtoNovo.setId(4L);
		produtoNovo.setNome("Spring Data");
		produtoNovo.setPreco(250.00);
		
		em.detach(produtoNovo); // o detach impede a operacao fazendo com que os comandos abaixo nao sejam executados
		
		em.getTransaction().begin();

		em.merge(produtoNovo);

		em.getTransaction().commit();
		
		Produto produtoVerificado = em.find(Produto.class, 4);

		assertNotNull(produtoVerificado);
		
	}
}
