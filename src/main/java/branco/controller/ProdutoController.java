package branco.controller;


import branco.dao.ProdutoDAO;
import branco.dao.ProdutoTesteDAO;
import branco.model.Produto;
import branco.model.ProdutoTeste;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class ProdutoController {
    @Autowired
    ProdutoDAO daoP;
    @Autowired
    ProdutoTesteDAO daoPT;

    @RequestMapping("/novoproduto")
    public String formProduto(Produto produto, Model model){
        return "criarProduto";
    }

    @RequestMapping("/salvarProduto")
    public String salvarProduto(@Valid Produto produto, BindingResult bindingResult, Model model) throws SQLException, ClassNotFoundException {
        if(bindingResult.hasErrors()){
            model.addAttribute("erro", "preencha todos os campos corretamente");
            return "criarProduto";
        }

        Integer Id = daoP.setProduto(produto);
        if ( Id > 0) {
            ProdutoTeste produtoTeste = new ProdutoTeste();
            produtoTeste.setProduto_teste_obs("Produto Novo Em Teste");
            produtoTeste.setProduto_id(Id);
            produtoTeste.setProduto_teste_data_inicio("kk");
            produtoTeste.setProduto_teste_data_final("-");
            produtoTeste.setProduto_teste_tipo_id(1);
            daoPT.novoTeste(produtoTeste);

            model.addAttribute("salvo", "Produto Salvo");
            return "criarProduto";




        } else {
            model.addAttribute("erro", "Algo deu errado!");
            return "criarProduto";
        }
    }


    @RequestMapping("/produto")
    public String listarProduto(Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("produtos", daoP.getProdutos());
        return "listaProdutos";
    }

    @RequestMapping("/editaproduto")
    public String editaProduto(@RequestParam int id, Model model) throws SQLException, ClassNotFoundException {
        model.addAttribute("produtoEdita", daoP.getProduto(id));
        return "criarProduto";

    }


    @RequestMapping("/excluirproduto")
    public String deletarProduto(@RequestParam int id, Model model) throws SQLException, ClassNotFoundException {
        if(daoP.deleteProduto(id)){
            model.addAttribute("produtoDeletado", "O Produto Foi Removido");
            return "redirect:/produto";
        }else {
            model.addAttribute("produtoDeletado", "Algo deu errado");
            return "redirect:/produto";
        }
    }



    @RequestMapping("/salvarProdutoEdita")
    public  String salvarEdicao(@Valid Produto produto, BindingResult bindingResult, Model m) throws SQLException, ClassNotFoundException {
        if(daoP.updateProduto(produto)){
            m.addAttribute("salvo", "Produto Atualizado");
            return "redirect:/produto";
        }else {
            m.addAttribute("salvo", "Produto Não Atualizado");
            return  "redirect:/produto";
        }

    }


}
