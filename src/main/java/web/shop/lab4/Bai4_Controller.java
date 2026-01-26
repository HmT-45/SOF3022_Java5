package web.shop.lab4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Bai4_Controller {
    @RequestMapping("/home/index")
    public String index(Model model) {
        return "/lab4/bai4_home";
    }

    @RequestMapping("/home/about")
    public String about(Model model) {
        return "/lab4/bai4_about";
    }

}
