package com.est_java.api_rest_full.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.est_java.api_rest_full.model.Produto;
import com.est_java.api_rest_full.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAllProdutos(){
        return produtoService.getAllProdutos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> getProdutoById(@PathVariable Integer id){
        return produtoService.getProdutoById(id);
    }

    @PostMapping
    public Produto addProduto(@RequestBody Produto produto){
        return produtoService.addProduto(produto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduto(@PathVariable Integer id){
        produtoService.deleteProduto(id);
        return "Produto com id:" + id + " foi deletado com sucesso!";
    }

    @PutMapping("/{id}")
    public Produto updateProduto(@RequestBody Produto produto, @PathVariable Integer id){
        return produtoService.updateProduto(id, produto);
    }

}
