package com.controller;


import com.controller.model.Funcionario;
import com.controller.model.Produto;
import com.controller.service.ProdutoService;
import com.controller.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class MiscController {

    @Autowired
    ProdutoService ps;
    
    @Autowired
    FuncionarioService fs;

    @GetMapping("/")
    public String mostraMenu() {
        return "index";
    }

  @GetMapping("/cadastroProduto")
public String mostraCadastroP(Model model) {
    Produto p = new Produto();
    model.addAttribute("produto", p);
    return "cadastroProduto";
}


    @GetMapping("/cadastroFuncionario")
    public String mostraCadastroF(Model model) {
        Funcionario f = new Funcionario();
        model.addAttribute("funcionario", f);
        return "cadastroFuncionario";
    }

    @PostMapping("/cadastroProduto")
    public String processaCadastroP(@ModelAttribute("produto") Produto produto, Model model) {
        ps.criarProduto(produto);
        return "redirect:/listaProduto";
    }

    @PostMapping("/cadastroFuncionario")
    public String processaCadastroF(@ModelAttribute("funcionario") Funcionario f, Model model) {
        fs.criarFuncionario(f);
        return "redirect:/listaFuncionario";
    }

    @GetMapping("/listaFuncionario")
    public String getAllFuncionarios(Model model) {
        model.addAttribute("lista", fs.listarTodosFuncionarios());
        return "listaFuncionario";
    }

    @GetMapping("/listaProduto")
    public String getAllProdutos(Model model) {
        model.addAttribute("lista", ps.listarTodosProdutos());
        return "listaProduto";
    }

    @GetMapping("atualizarProduto/{id}")
    public String atualizaProduto(@PathVariable(value = "id") Integer id, Model model) {
        Produto p = ps.getProdutoId(id);
        model.addAttribute("produto", p);
        return "atualizar";
    }

    @GetMapping("deletarProduto/{id}")
    public String deletaProduto(@PathVariable(value = "id") Integer id) {
        ps.deletarProduto(id);
        return "redirect:/listaProduto";

    }

    @GetMapping("deletarFuncionario/{id}")
    public String deletaFuncionario(@PathVariable(value = "id") Integer id) {
        fs.deletarFuncionario(id);
        return "redirect:/listaFuncionario";

    }

    @PostMapping("atualizar")
    public String processaproduto(@ModelAttribute(value = "produto") Produto produto) {
        ps.atualizarProduto(produto.getId(), produto);
        return "redirect:/listaProduto";
    }

}
