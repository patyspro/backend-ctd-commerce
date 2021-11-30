package com.ctd.commerce.controller;
import com.ctd.commerce.model.Categoria;
import com.ctd.commerce.model.Produto;
import com.ctd.commerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    private ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.cadastrarProduto(produto));
    }

    @GetMapping
    private ResponseEntity<List<Produto>> listarTodosProdutos(){
        return ResponseEntity.ok(produtoService.listarTodosProdutos());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Optional<Produto>> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @GetMapping("/categoria/{categoria}")
    private ResponseEntity<List<Produto>> produtosDeUmaCategoria(@PathVariable Categoria categoria){
        return ResponseEntity.ok(produtoService.findAllByCategoria(categoria));
    }
}
