package web.shop.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Bai2_ParamController {

    @RequestMapping("/param/form")
    public String form() {
        return "/lab2/bai2_form";
    }

    @RequestMapping("/param/save/{x}")
    public String save(
            @PathVariable("x") String x,
            @RequestParam("y") String y,
            Model model
    ){
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "/lab2/bai2_form";
    }
}//end class
