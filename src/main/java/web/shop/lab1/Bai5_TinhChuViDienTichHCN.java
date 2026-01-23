package web.shop.lab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Bai5_TinhChuViDienTichHCN {

    @GetMapping("/lab1bai5/form")
    public String form(){
        return "/lab1/Lab1Bai5";
    }

    @PostMapping("/lab1bai5/result")
    public String result(
        @RequestParam("chieudai") double chieudai,
        @RequestParam("chieurong") double chieurong,
        Model model){

        double chuvi = (chieudai + chieurong)*2;
        double dientich = chieudai * chieurong;

        model.addAttribute("chuvi",chuvi);
        model.addAttribute("dientich", dientich);
        return "/lab1/Lab1Bai5";
    }
}
