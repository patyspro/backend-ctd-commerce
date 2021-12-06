package com.ctd.commerce.service;

import com.ctd.commerce.model.Produto;
import com.ctd.commerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodosProdutos(){
       return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Integer id){
        return produtoRepository.findById(id);
    }

    //Listar produtos por título
    public List<Produto> listarPorTitulo(String titulo) {
        return produtoRepository.findByTitulo(titulo);
    }

    public Produto cadastrarProduto(Produto produto){
         return produtoRepository.save(produto);
    }
}
