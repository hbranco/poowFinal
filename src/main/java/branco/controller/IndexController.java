package branco.controller;

import branco.bean.UsuarioBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Scope("session")
public class IndexController {
    @Autowired
    UsuarioBean usuarioLogado;

    @RequestMapping("/")
    public String index(Model m){
        return "index";
    }


    @RequestMapping("logout")
    public String home(){
            usuarioLogado.setUsuario(null);
            return "redirect:/";
    }
}
