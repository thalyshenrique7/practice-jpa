package com.devthalys.EntityManager.listerners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.devthalys.EntityManager.model.Produto;

/**
 * Sempre que houver uma alteracao em algum campo do sistema, 
 * podemos chamar outra parte do sistema (Listerners)
 */

public class GerarNotaFiscalListerner {
	
	/**
	 * Precisa anotar a entidade com @EntityListerners({ GerarNotaFiscalListener.class })
	 */
	
	@PrePersist
	@PreUpdate
	public void gerar(Produto produto) {
		if(produto.getId() != null) {
			System.out.println("Gerando nota fiscal para o produto " + produto.getId() + ".");
		}
	}
}
