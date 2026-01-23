package web.shop.lab1;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Bai4_AuthController {

    @Autowired
    private HttpServletRequest request;

    // phương thức hiển thị form
    @GetMapping("/login/form")
    public String form(){
        return "/lab1/form";
    }

    // phương thức xử lý đăng nhập
    @PostMapping("/login/check")
    public String login(Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hello = request.getParameter("hello");

        if("poly".equals(username) & "123".equals(password)){
            model.addAttribute("message", "Dang nhap thanh cong");
            model.addAttribute("hello", "Poly Hello");
        }else{
            model.addAttribute("message", "Dang nhap that bai");
        }
        return "/lab1/form";
    }
}
