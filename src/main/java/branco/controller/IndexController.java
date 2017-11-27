package branco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model m){
        return "index";

    }

    @RequestMapping("logout")
    public String home(){
        return "redirect:/";

    }

}
