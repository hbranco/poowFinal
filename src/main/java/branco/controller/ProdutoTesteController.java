package branco.controller;


import branco.dao.ProdutoDefeitoDAO;
import branco.dao.ProdutoTesteDAO;
import branco.model.ProdutoTeste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class ProdutoTesteController {

    @Autowired
    ProdutoTesteDAO daoPT;
    @Autowired
    ProdutoDefeitoDAO daoDF;

    @RequestMapping("/produtoteste")
    public String getProdutoTeste(Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("produtoTeste", daoPT.getProtudoTeste());
        return "produtoTeste";
    }



    @RequestMapping("/editaprodutoteste")
    public String getProdutoTesteForm(@RequestParam int id, Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("produtoTeste", daoPT.getProdutoEmTeste(id));
        return "editarTeste";
    }

    @RequestMapping("/salvarEditaTeste")
    public String updateTeste(ProdutoTeste produtoTeste) throws SQLException, ClassNotFoundException {
        if(daoPT.updateProdutoEmteste(produtoTeste)){
            return "redirect:produtoteste";
        }else{
            return "redirect:produtoteste";
        }
    }


    @RequestMapping("/finalizarteste")
    public String finalizarTeste(@RequestParam int teste_id, @RequestParam int produto_id,Model model) throws SQLException, ClassNotFoundException {
        if(daoPT.finalizarTeste(teste_id)){
            return "redirect:produtoteste";
        }

        return "redirect:produtoteste";
    }


    @RequestMapping("/produtodefeito")
    public String produtoDefeito(@RequestParam int teste_id, @RequestParam int produto_id,Model model) throws SQLException, ClassNotFoundException {
        if(daoPT.finalizarTeste(teste_id)){
                daoDF.produtoComDefeito(produto_id);
            return "redirect:defeito";
        }

        return "redirect:produtoteste";
    }



}
