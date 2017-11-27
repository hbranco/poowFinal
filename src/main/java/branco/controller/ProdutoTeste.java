package branco.controller;


import branco.dao.ProdutoTesteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class ProdutoTeste {

    @Autowired
    ProdutoTesteDAO daoPT;

    @RequestMapping("/produtoteste")
    public String getProdutoTeste(Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("produtoTeste", daoPT.getProtudoTeste());
        return "produtoTeste";
    }


}
