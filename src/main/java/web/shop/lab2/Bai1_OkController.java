package web.shop.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Bai1_OkController {

    @RequestMapping("/ok")
    public String ok(){
        return "/lab2/ok";
    }

    @PostMapping("/ctrl/ok")
    public String m1(Model model){
        model.addAttribute("method", "m1");
        return "/lab2/ok";
    }

    @GetMapping("/ctrl/ok")
    public String m2(Model model){
        model.addAttribute("method", "m2");
        return "/lab2/ok";
    }

    @PostMapping(value="/ctrl/ok", params ="x")
    public String m3(Model model){
        model.addAttribute("method", "m3");
        return "/lab2/ok";
    }

}
