package branco.controller;

import branco.bean.UsuarioBean;
import branco.dao.ProdutoDefeitoDAO;
import branco.dao.ProdutoEstoqueDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
@Scope("session")
public class ProdutoEstoqueController {

    @Autowired
    UsuarioBean usuarioLogado;

    @Autowired
    ProdutoEstoqueDAO daoPE;


    /**
     * metodo que retorna todos os produtos na fila de teste
     * @param model
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @RequestMapping("/produtoestoque")
    public  String getProdutoEstoque(Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("produtoEstoque",daoPE.getProdutoEstoque());
        model.addAttribute("usuario", usuarioLogado.getUsuario());
        if(usuarioLogado.getUsuario() != null){
            return "produtoEstoque";
        }else{
            return "redirect:/";
        }

    }


    /**
     * Metodo que muda o status de um produto de Estoque para Vendido
     * @param id
     * @param model
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @RequestMapping("/vendido")
    public String updateProdutoEstoque(@RequestParam int id, Model model) throws SQLException, ClassNotFoundException {
        if(usuarioLogado.getUsuario() != null){
            if(daoPE.produtoVendido(id)){
                model.addAttribute("usuario", usuarioLogado.getUsuario());
                return "redirect:produtoestoque";
            }else{
                model.addAttribute("usuario", usuarioLogado.getUsuario());
                return "redirect:produtoestoque";
            }
        }
        return "redirect:/";
    }







}
