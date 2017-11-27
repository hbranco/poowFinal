package branco.controller;


import branco.dao.ProdutoDefeitoDAO;
import branco.dao.ProdutoEstoqueDAO;
import branco.dao.ProdutoTesteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HttpSessionMutexListener;

import java.sql.SQLException;

@Controller
public class DashboardController {
    @Autowired
    ProdutoEstoqueDAO daoPE;
    @Autowired
    ProdutoTesteDAO daoPT;
    @Autowired
    ProdutoDefeitoDAO daoPD;

@RequestMapping("/dashboard")
    public String inicio(Model model, HttpSessionMutexListener httpSessionMutexListener) throws SQLException, ClassNotFoundException {
    model.addAttribute("defeito",daoPD.totalDefeito());
    model.addAttribute("estoque",daoPE.totalEstoque());
    model.addAttribute("teste",daoPT.totalTeste());
    model.addAttribute("venvido", daoPE.totalVendido());
    return "dashboard";
}


}
