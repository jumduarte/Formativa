package com.empresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entities.Produto;
import com.empresa.repository.ProdutoRepository;

	@Service
	public class ProdutoService {
	    private final ProdutoRepository produtoRepository;
	    
	    @Autowired
	    public ProdutoService(ProdutoRepository produtoRepository) {
	        this.produtoRepository = produtoRepository;
	    }

	    public List<Produto> getAllProduto() {
	        return produtoRepository.findAll();
	    }

	    public Produto getProdutoById(Long id) {
	        Optional<Produto> pedido = produtoRepository.findById(id);
	        return pedido.orElse(null);
	    }

	    public Produto salvarProduto(Produto produto) {
	        return produtoRepository.save(produto);
	    }

	    public Produto updateProduto(Long id, Produto updatedProduto) {
	        Optional<Produto> existingProduto = produtoRepository.findById(id);
	        if (existingProduto.isPresent()) {
	            updatedProduto.setId(id);
	            return produtoRepository.save(updatedProduto);
	        }
	        return null;
	    }
	    public boolean deleteProduto(Long id) {
	        Optional<Produto> existingProduto = produtoRepository.findById(id);
	        if (existingProduto.isPresent()) {
	        	produtoRepository.deleteById(id);
	           return true;
	        }
	        return false;
	    }
}
