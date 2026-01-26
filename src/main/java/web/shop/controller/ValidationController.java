package web.shop.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidationController {
    @RequestMapping("/students/form")
    public String showForm(Model model, @ModelAttribute Student student) {
        model.addAttribute("message", "Vui lòng nhập thông tin sinh viên!");
        return "/demo/student";
    }

    @RequestMapping("/students/save")
    public String validationForm(Model model,
                                 @ModelAttribute @Valid Student student, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            model.addAttribute("message", "Dữ liệu đã nhập đúng!");
        }
        return "/demo/student";
    }
}
