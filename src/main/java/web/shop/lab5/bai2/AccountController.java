package web.shop.lab5.bai2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.shop.lab5.bai1.CookieService;
import web.shop.lab5.bai1.ParamService;
import web.shop.lab5.bai1.SessionService;

@Controller
public class AccountController {

    @Autowired
    CookieService cookieService;
    @Autowired
    ParamService paramService;
    @Autowired
    SessionService sessionService;

    @GetMapping("/account/login")
    public String login(Model model) {
        // remember username
        String rememberedUser = cookieService.getValue("user");
        model.addAttribute("username", rememberedUser);

        // login state
        String loginUser = sessionService.get("loginUser");
        model.addAttribute("loginUser", loginUser);

        return "/lab5/login";
    }

    @PostMapping("/account/login")
    public String loginPost(Model model) {

        String action = paramService.getString("action", "");

        // LOGOUT
        if (action.equals("logout")) {
            sessionService.remove("loginUser");
            cookieService.remove("user");
            return "redirect:/account/login";
        }

        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);

        // LOGIN SUCCESS
        if (un.equals("poly") && pw.equals("123")) {

            // set session login
            sessionService.set("loginUser", un);

            // remember username
            if (rm) {
                cookieService.add("user", un, 10);
            } else {
                cookieService.remove("user");
            }

            return "redirect:/account/login";
        }

        // LOGIN FAIL
        model.addAttribute("username", un);
        model.addAttribute("message", "Sai tài khoản hoặc mật khẩu");
        return "/lab5/login";
    }
}