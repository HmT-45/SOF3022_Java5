package web.shop.lab4;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
//Bài 1
public class Bai1va2_StaffController {
    @RequestMapping("/staff/create/form")
    public String createForm(Model model, @ModelAttribute("staff") Bai1_Staff staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "/lab4/bai1_staff-create";
    }
    @PostMapping("/staff/create/save")
    public String createSave(
            Model model,
            @ModelAttribute("staff") Bai1_Staff staff,
            @RequestPart("photo_file") MultipartFile photoFile
    ) {
        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }
        model.addAttribute("message", "Xin chào " + staff.getFullname());
        return "/lab4/bai1_staff-create";
    }
    //Bài 2
    @GetMapping("/sx")
    public String validateForm(Model model) {
        model.addAttribute("staff", new Bai1_Staff());
        return "/lab4/bai2_staff-validate";
    }

    @PostMapping("/staff/validate/save")
    public String validateSave(
            Model model,
            @Valid @ModelAttribute("staff") Bai1_Staff staff,
            Errors errors,
            @RequestPart("photo_file") MultipartFile photoFile
    ) {
        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }

        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            model.addAttribute("message", "Dữ liệu đã nhập đúng!");
        }
        return "/lab4/bai2_staff-validate";
    }
    }
