package branco.controller;


import branco.dao.UsuarioDAO;
import branco.model.Usuario;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;



@Controller
public class UsuarioController {

    @Autowired UsuarioDAO daoU;

    @PostMapping("/autenticar")
    public String autenticar(Usuario usuario, Model model) throws SQLException, ClassNotFoundException {
        System.out.println("aqi");
        if(daoU.autentica(usuario)){
            model.addAttribute("usuario", usuario);
            return "dashboard";
        }else {
            return "index";

        }
    }


    @GetMapping("/novousuario")
    public String novoUsuario(){
        return "criarConta";

    }


    @PostMapping("/cadastrarusuario")
    public String cadastrarUsuario(Usuario usuario, Model model) throws SQLException, ClassNotFoundException {
        if(daoU.cadastrar(usuario)){

            model.addAttribute("usuario", usuario);
            return "index";

        }else{
            return "criarConta";

        }

    }



}
