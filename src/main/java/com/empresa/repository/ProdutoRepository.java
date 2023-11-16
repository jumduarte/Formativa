package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.empresa.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}