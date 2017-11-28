package branco.controller;


import branco.bean.UsuarioBean;
import branco.dao.ProdutoDefeitoDAO;
import branco.dao.ProdutoEstoqueDAO;
import branco.dao.ProdutoTesteDAO;
import branco.model.ProdutoTeste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
@Scope("session")
public class ProdutoTesteController {

    @Autowired
    ProdutoTesteDAO daoPT;
    @Autowired
    ProdutoDefeitoDAO daoDF;
    @Autowired
    ProdutoEstoqueDAO daoPE;

    @Autowired
    UsuarioBean usuarioLogado;

    @RequestMapping("/produtoteste")
    public String getProdutoTeste(Model model) throws SQLException, ClassNotFoundException {
        if(usuarioLogado.getUsuario() != null){
            model.addAttribute("produtoTeste", daoPT.getProtudoTeste());
            model.addAttribute("usuario", usuarioLogado.getUsuario());
            return "produtoTeste";
        }else{
            return "redirect:/";
        }


    }



    @RequestMapping("/editaprodutoteste")
    public String getProdutoTesteForm(@RequestParam int id, Model model) throws SQLException, ClassNotFoundException {
        if(usuarioLogado.getUsuario() != null){
            model.addAttribute("produtoTeste", daoPT.getProdutoEmTeste(id));
            model.addAttribute("usuario", usuarioLogado.getUsuario());
            return "editarTeste";

        }else{
            return "redirect:/";
        }

    }

    @RequestMapping("/salvarEditaTeste")
    public String updateTeste(ProdutoTeste produtoTeste, Model model) throws SQLException, ClassNotFoundException {
        if(usuarioLogado.getUsuario() != null){
            if(daoPT.updateProdutoEmteste(produtoTeste)) {
                model.addAttribute("usuario", usuarioLogado.getUsuario());
                return "redirect:produtoteste";
            }else {
                model.addAttribute("usuario", usuarioLogado.getUsuario());
                return "redirect:produtoteste";
            }
        }else{
            return "redirect:/";
        }


    }


    @RequestMapping("/finalizarteste")
    public String finalizarTeste(@RequestParam int teste_id, @RequestParam int produto_id,Model model) throws SQLException, ClassNotFoundException {
        if(usuarioLogado.getUsuario() != null){
            if(daoPT.finalizarTeste(teste_id)){
                model.addAttribute("usuario", usuarioLogado.getUsuario());
                daoPE.produtoEstoque(produto_id);
                return "redirect:produtoteste";
            }else{
                model.addAttribute("usuario", usuarioLogado.getUsuario());
                return "redirect:produtoteste";
            }
        }
        return "redirect:/";
    }


    @RequestMapping("/produtodefeito")
    public String produtoDefeito(@RequestParam int teste_id, @RequestParam int produto_id,Model model) throws SQLException, ClassNotFoundException {
        if (usuarioLogado.getUsuario() != null) {
            if (daoPT.finalizarTeste(teste_id)) {
                daoDF.produtoComDefeito(produto_id);
                model.addAttribute("usuario", usuarioLogado.getUsuario());
                return "redirect:defeito";
            }
            model.addAttribute("usuario", usuarioLogado.getUsuario());
            return "redirect:produtoteste";
        }
        return "redirect:/";
    }

}
