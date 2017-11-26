package branco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model m){
//        m.addAttribute("someAttribute", "algum valor");
        return "index";

    }

    @RequestMapping("dashboard")
    public String home(){
        return "dashboard";

    }

}
