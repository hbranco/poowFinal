package branco.controller;

import branco.dao.ProdutoDefeitoDAO;
import branco.dao.ProdutoEstoqueDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class ProdutoEstoqueController {

    @Autowired
    ProdutoEstoqueDAO daoPE;
    @RequestMapping("/produtoestoque")
    public  String getProdutoEstoque(Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("produtoEstoque",daoPE.getProdutoEstoque());
        return "produtoEstoque";
    }


    @RequestMapping("/vendido")
    public String updateProdutoEstoque(@RequestParam int id, Model model) throws SQLException, ClassNotFoundException {
        if(daoPE.produtoVendido(id)){
            return "redirect:produtoestoque";
        }
        return "redirect:produtoestoque";
    }







}
