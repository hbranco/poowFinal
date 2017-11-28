package branco.controller;


import branco.bean.UsuarioBean;
import branco.dao.ProdutoDAO;
import branco.dao.ProdutoTesteDAO;
import branco.model.Produto;
import branco.model.ProdutoTeste;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.sql.SQLException;

@Controller
@Scope("session")
public class ProdutoController {
    @Autowired
    ProdutoDAO daoP;
    @Autowired
    ProdutoTesteDAO daoPT;
    @Autowired
    UsuarioBean usuarioBean;

    @RequestMapping("/novoproduto")
    public String formProduto(Produto produto, Model model){
        if(usuarioBean.getUsuario() != null){
            model.addAttribute("usuario", usuarioBean.getUsuario());
            return "criarProduto";
        }else {
            return  "redirect:/";
        }
    }

    @RequestMapping("/salvarProduto")
    public String salvarProduto(@Valid Produto produto, BindingResult bindingResult, Model model) throws SQLException, ClassNotFoundException {
        if(usuarioBean.getUsuario() != null){
            if(bindingResult.hasErrors()){
                model.addAttribute("erro", "preencha todos os campos corretamente");
                model.addAttribute("usuario", usuarioBean.getUsuario());
                return "criarProduto";
            }

            Integer Id = daoP.setProduto(produto);
            if ( Id > 0) {
                ProdutoTeste produtoTeste = new ProdutoTeste();
                produtoTeste.setProduto_teste_obs("Produto Novo Em Teste");
                produtoTeste.setProduto_id(Id);
                produtoTeste.setProduto_teste_data_inicio(produto.getProduto_data_fabricacao());
                produtoTeste.setProduto_teste_data_final("-");
                produtoTeste.setProduto_teste_tipo_id(1);
                daoPT.novoTeste(produtoTeste);
                model.addAttribute("salvo", "Produto Salvo");
                model.addAttribute("usuario", usuarioBean.getUsuario());
                return "redirect:/produtoteste";
            } else {
                model.addAttribute("erro", "Algo deu errado!");
                model.addAttribute("usuario", usuarioBean.getUsuario());
                return "criarProduto";
            }
        }else{
            return "redirect:/";
        }
    }


    @RequestMapping("/produto")
    public String listarProduto(Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("produtos", daoP.getProdutos());
        if(usuarioBean.getUsuario() != null){
            model.addAttribute("usuario", usuarioBean.getUsuario());
            return "listaProdutos";
        }else{
            return "redirect:/";
        }
    }

    @RequestMapping("/editaproduto")
    public String editaProduto(@RequestParam int id, Model model) throws SQLException, ClassNotFoundException {
        if(usuarioBean.getUsuario() != null){
            model.addAttribute("produtoEdita", daoP.getProduto(id));
            model.addAttribute("usuario", usuarioBean.getUsuario());
            return "criarProduto";
        }else{
            return "redirect:/";
        }

    }


    @RequestMapping("/excluirproduto")
    public String deletarProduto(@RequestParam int id, Model model) throws SQLException, ClassNotFoundException {
        if(usuarioBean.getUsuario() != null){
            if(daoP.deleteProduto(id)){
                model.addAttribute("produtoDeletado", "O Produto Foi Removido");
                model.addAttribute("usuario", usuarioBean.getUsuario());
                return "redirect:/produto";
            }else {
                model.addAttribute("produtoDeletado", "Algo deu errado");
                model.addAttribute("usuario", usuarioBean.getUsuario());
                return "redirect:/produto";
            }
        }else{
            return "redirect:/";
        }
    }

    @RequestMapping("/salvarProdutoEdita")
    public  String salvarEdicao(@Valid Produto produto, BindingResult bindingResult, Model model) throws SQLException, ClassNotFoundException {

        if(usuarioBean.getUsuario() != null){
            if(daoP.updateProduto(produto)){
                model.addAttribute("salvo", "Produto Atualizado");
                model.addAttribute("usuario", usuarioBean.getUsuario());
                return "redirect:/produto";
            }else {
                model.addAttribute("usuario", usuarioBean.getUsuario());
                model.addAttribute("salvo", "Produto Não Atualizado");
                return  "redirect:/produto";
            }
        }else{
            return "redirect:/";
        }
    }
}
