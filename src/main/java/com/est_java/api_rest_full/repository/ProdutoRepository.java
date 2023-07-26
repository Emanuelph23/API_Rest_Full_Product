package com.est_java.api_rest_full.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.est_java.api_rest_full.model.Produto;
import com.est_java.api_rest_full.model.exception.ResourceNotFoundException;

@Repository
public class ProdutoRepository {
    
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer id_Db = 0;

    /**
     * Método para buscar todos os produtos
     * @return uma lista de produtos
     */
    public List<Produto> getAllProdutos() {
        return produtos;
    }

    /**
     * Método para buscar um produto pelo id
     * @param id do produto a ser buscado
     * @return um produto caso seja encontrado
     */
    public Optional<Produto> getProdutoById(Integer id){

        return produtos.stream()
            .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    /**
     * Método para adicionar produto
     * @param produto que será adicionado
     * @return o produto adicionado
     */
    public Produto addProduto(Produto produto){

        id_Db++;

        produto.setId(id_Db);
        produtos.add(produto);

        return produto;
    }

    /**
     * Método para deletar o produto por id
     * @param id do produto a ser deletado
     */
    public void deleteProduto(Integer id){

        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Método para atualizar o produto
     * @param produto que será atualizado
     * @return o produto atualizado
     */
    public Produto updateProduto(Produto produto){

        Optional<Produto> produtoFound =  getProdutoById(produto.getId());

        if(produtoFound.isEmpty()){
            throw new ResourceNotFoundException("Produto não pode ser atualizado pois não existe!");
        }

        deleteProduto(produto.getId());

        produtos.add(produto);

        return produto;
    }

}
