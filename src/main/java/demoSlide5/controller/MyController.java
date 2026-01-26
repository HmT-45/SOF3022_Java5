package demoSlide5.controller;

import demoSlide5.service.interfaces.CookieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @Autowired
    CookieService cookieService;

    @RequestMapping("/test/bean")
    public String bean() {
        cookieService.create("Tri", "hai muoi", (10 * 24 * 60 * 60));
        return null;
    }
}
