package com.est_java.api_rest_full.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.est_java.api_rest_full.model.Produto;
import com.est_java.api_rest_full.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Método para buscar todos os produtos
     * @return uma lista de produtos
     */
    public List<Produto> getAllProdutos() {
        return produtoRepository.getAllProdutos();
    }

    /**
     * Método para buscar um produto pelo id
     * @param id do produto a ser buscado
     * @return um produto caso seja encontrado
     */
    public Optional<Produto> getProdutoById(Integer id){
        return produtoRepository.getProdutoById(id);
    }

    /**
     * Método para adicionar produto
     * @param produto que será adicionado
     * @return o produto adicionado
     */
    public Produto addProduto(Produto produto){
        return produtoRepository.addProduto(produto);
    }

    /**
     * Método para deletar o produto por id
     * @param id do produto a ser deletado
     */
    public void deleteProduto(Integer id){
        produtoRepository.deleteProduto(id);
    }

    /**
     * Método para atualizar o produto
     * @param produto que será atualizado
     * @param id do produto a ser atualizado
     * @return o produto atualizado
     */
    public Produto updateProduto(Integer id,Produto produto){
        
        produto.setId(id);

        return produtoRepository.updateProduto(produto);
    }

}
