package branco.controller;


import branco.bean.UsuarioBean;
import branco.dao.UsuarioDAO;
import branco.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;



@Controller
@Scope("session")
public class UsuarioController {

    @Autowired UsuarioDAO daoU;

    @Autowired
    UsuarioBean usuarioBean;



    @RequestMapping("/autenticar")
    public String autenticar(@Valid Usuario usuario, BindingResult result, Model model) throws SQLException, ClassNotFoundException {
       if(result.hasErrors()){
           model.addAttribute("erroSenha", "a senha deve conter 6 digitos");
           return "index";

       }else {
           if(daoU.autentica(usuario)){
               model.addAttribute("usuario", usuario);
               usuarioBean.setUsuario(usuario);
               return "redirect:dashboard";
           }else {
               model.addAttribute("usuarioInvalido", "usuário não encontrado!");
               return "index";
           }
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
