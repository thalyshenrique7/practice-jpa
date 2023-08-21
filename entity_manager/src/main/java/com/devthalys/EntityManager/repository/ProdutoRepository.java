package com.devthalys.EntityManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devthalys.EntityManager.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
