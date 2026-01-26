package web.shop.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Bai3_ProductController {

    @GetMapping("/product/form")
    public String form() {
        return "/lab2/bai3_view";
    }

    @PostMapping("/product/save")
    public String save(
            @RequestParam("name") String name,
            @RequestParam("price") Integer price,
            Model model
    ) {
        model.addAttribute("name", name);
        model.addAttribute("price", price);
        return "/lab2/bai3_view";
    }


}
