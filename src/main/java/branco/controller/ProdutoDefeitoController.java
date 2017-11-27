package branco.controller;

import branco.dao.ProdutoDefeitoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class ProdutoDefeitoController {
    @Autowired
    ProdutoDefeitoDAO daoDF;


    @RequestMapping("/defeito")
    public String getProdutoDefeito(Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("defeito", daoDF.getProdutoDefeito());
        return "produtoDefeito";

    }



    @RequestMapping("/retestar")
    public String novoTeste(@RequestParam int produto_defeito_id, @RequestParam int produto_id, Model model) throws SQLException, ClassNotFoundException {
        if(daoDF.produtoConsertado(produto_defeito_id,produto_id)){

            return "redirect:produtoteste";
        }
        return "redirect:produtoteste";

    }




}
