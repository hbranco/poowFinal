package branco.controller;


import branco.bean.UsuarioBean;
import branco.dao.ProdutoDefeitoDAO;
import branco.dao.ProdutoEstoqueDAO;
import branco.dao.ProdutoTesteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HttpSessionMutexListener;

import java.sql.SQLException;

@Controller
@Scope("session")
public class DashboardController {
    @Autowired
    ProdutoEstoqueDAO daoPE;
    @Autowired
    ProdutoTesteDAO daoPT;
    @Autowired
    ProdutoDefeitoDAO daoPD;

    @Autowired
    UsuarioBean usuarioLogado;


    /**
     * Metodo que retorna a view com a dashboard(tela inicial)
     * @param model
     * @param httpSessionMutexListener
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @RequestMapping("/dashboard")
    public String inicio(Model model, HttpSessionMutexListener httpSessionMutexListener) throws SQLException, ClassNotFoundException {
        if(usuarioLogado.getUsuario() != null){
            model.addAttribute("defeito",daoPD.totalDefeito());
            model.addAttribute("estoque",daoPE.totalEstoque());
            model.addAttribute("teste",daoPT.totalTeste());
            model.addAttribute("venvido", daoPE.totalVendido());
            model.addAttribute("usuario", usuarioLogado.getUsuario());
            return "dashboard";
        }else{
            return "redirect:/";
        }
    }


}
