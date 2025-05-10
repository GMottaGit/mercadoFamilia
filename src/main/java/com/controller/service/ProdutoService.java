
package com.controller.service;

import com.controller.model.Produto;
import com.controller.model.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository pr;
    public Produto criarProduto(Produto produto) {
        produto.setId(null);
        pr.save(produto);
        return produto;
    }

    public List<Produto> listarTodosProdutos() {
        return pr.findAll();
    }
    public Produto getProdutoId(Integer funcId){
        Produto p = pr.findById(funcId).orElse(null);
        return p;
    }
    public Produto atualizarProduto(Integer id, Produto produtoRequest){
        
        Produto produto = this.getProdutoId(id);
        produto.setNome(produtoRequest.getNome());
        produto.setPreco(produtoRequest.getPreco());
        produto.setQuantidade(produtoRequest.getQuantidade());
        pr.save(produto);
        return produto;
    }
    public void deletarProduto(Integer id){
       
        Produto produto = this.getProdutoId(id);
        pr.deleteById(produto.getId());
        
    }
}
