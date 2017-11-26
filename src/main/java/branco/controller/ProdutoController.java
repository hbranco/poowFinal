package branco.controller;


import branco.dao.ProdutoDAO;
import branco.model.Produto;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class ProdutoController {
    @Autowired
    ProdutoDAO daoP;

    @RequestMapping("/novoproduto")
    public String formProduto(Produto produto, Model model){
        return "criarProduto";
    }

    @RequestMapping("/salvarProduto")
    public String salvarProduto(@Valid Produto produto, BindingResult bindingResult, Model model) throws SQLException, ClassNotFoundException {
        if(bindingResult.hasErrors()){
            model.addAttribute("erro", "preencha todos os campos corretamente");
            return "criarProduto";
        }

        if(daoP.setProduto(produto)){
            model.addAttribute("salvo", "Produto Salvo");
            return "criarProduto";
        }else {
            model.addAttribute("erro", "Algo deu errado!");
            return "criarProduto";
        }
    }


    @RequestMapping("/produto")
    public String listarProduto(Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("produtos", daoP.getProdutos());
        return "listaProdutos";
    }

    @RequestMapping("/editaproduto")
    public String editaProduto(@RequestParam int id, Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("produtoEdita", daoP.getProduto(id));
        return "criarProduto";

    }


    @RequestMapping("/salvarProdutoEdita")
    public  String salvarEdicao(@Valid Produto produto, BindingResult bindingResult, Model m) throws SQLException, ClassNotFoundException {
        if(daoP.updateProduto(produto)){
            m.addAttribute("salvo", "Produto Atualizado");
            return "redirect:/produto";
        }else {
            m.addAttribute("salvo", "Produto Não Atualizado");
            return  "redirect:/produto";
        }

    }


}
