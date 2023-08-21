package com.devthalys.EntityManager;

import org.junit.jupiter.api.Test;

public class CallbacksTest {

	@Test
	void acionarCallbacks() {

		/**
		 * Ao mudar o tipo de um dado que já foi gravado no banco ira gerar um erro
		 * Devemos chamar um metodo para salvar essa alteracao antes usamos 2
		 * anotacoes @PrePersist e @PreUpdate, porem possui mais anotacoes,
		 * exemplo: @PostPersist, @PostLoad etc
		 * 
		 * Alteracoes devem ser feitas na entidade
		 * 
		 * Só pode ter um único @PrePersist em cada entidade
		 */
	}
}
