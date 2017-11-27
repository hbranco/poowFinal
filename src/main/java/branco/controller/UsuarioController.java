package branco.controller;


import branco.dao.UsuarioDAO;
import branco.model.Usuario;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.SQLException;



@Controller
public class UsuarioController {

    @Autowired UsuarioDAO daoU;

    @RequestMapping("/autenticar")
    public String autenticar(@Valid Usuario usuario, BindingResult result, Model model) throws SQLException, ClassNotFoundException {
       if(result.hasErrors()){
           model.addAttribute("erroSenha", "a senha deve conter 6 digitos");
           return "index";

       }else {
           if(daoU.autentica(usuario)){
               model.addAttribute("usuario", usuario);
//               redirectAttributes.addAttribute("usuario", usuario);
               return "dashboard";
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
