package web.shop.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class Bai4_ProductController {

    @GetMapping("/productbai4/form")
    public String form(Model model) {
        Bai3_Pruduct p = new Bai3_Pruduct();
        p.setName("iPhone 30");
        p.setPrice(5000.0);

        model.addAttribute("product", p);

        return "/lab2/bai4_view";
    }
    @PostMapping("/productbai4/save")
    public String save(@ModelAttribute("product") Bai3_Pruduct p, Model model) {
        model.addAttribute("product", p);
        return "/lab2/bai4_view";
    }

    @ModelAttribute("items")
    public List<Bai3_Pruduct> getItems() {
        return Arrays.asList(
                new Bai3_Pruduct("A", 1.0),
                new Bai3_Pruduct("B", 12.0)
        );
    }
}
