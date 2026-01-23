package web.shop.lab3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Bai1_detail_Controller {
    @RequestMapping("/staff/detail")
    public String detail(Model model) {
        Bai1_Staff staff = Bai1_Staff.builder()
                .photo("hinhconong.png")
                .id("user@gmail.com")
                .fullname("nguyễn văn user")
                .level(2)
                .build();
        model.addAttribute("staff", staff);
        return "/lab3/bai1_staff-detail";
    }
}
