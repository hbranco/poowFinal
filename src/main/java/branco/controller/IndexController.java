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

    /**
     * metodo que retorna a tela de login
     * @param m
     * @return
     */
    @RequestMapping("/")
    public String index(Model m){
        return "index";
    }


    /**
     * metodo que faz logut do sistema
     * @return
     */
    @RequestMapping("logout")
    public String home(){
            usuarioLogado.setUsuario(null);
            return "redirect:/";
    }
}
