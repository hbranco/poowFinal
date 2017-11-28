package branco.controller;

import branco.bean.UsuarioBean;
import branco.dao.ProdutoDefeitoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
@Scope("session")
public class ProdutoDefeitoController {
    @Autowired
    ProdutoDefeitoDAO daoDF;

    @Autowired
    UsuarioBean usuarioLogado;

    @RequestMapping("/defeito")
    public String getProdutoDefeito(Model model) throws SQLException, ClassNotFoundException {
        if(usuarioLogado.getUsuario() != null){
            model.addAttribute("defeito", daoDF.getProdutoDefeito());
            model.addAttribute("usuario", usuarioLogado.getUsuario());
            return "produtoDefeito";
        }else{
            return "redirect:/";
        }
    }



    @RequestMapping("/retestar")
    public String novoTeste(@RequestParam int produto_defeito_id, @RequestParam int produto_id, Model model) throws SQLException, ClassNotFoundException {
        if(usuarioLogado.getUsuario() != null){
            if(daoDF.produtoConsertado(produto_defeito_id,produto_id)){
                model.addAttribute("usuario", usuarioLogado.getUsuario());
                return "redirect:produtoteste";
            }else{
                model.addAttribute("usuario", usuarioLogado.getUsuario());
                return "redirect:produtoteste";
            }
        }
        return "redirect:/";
    }
}
