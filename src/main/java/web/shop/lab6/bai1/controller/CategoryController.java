package web.shop.lab6.bai1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.shop.lab6.bai1.Repository.CategoryDAO;
import web.shop.lab6.bai1.model.Category;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryDAO dao;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("item", new Category());
        model.addAttribute("items", dao.findAll());
        model.addAttribute("mode", "CREATE");
        return "lab6/index";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        model.addAttribute("item", dao.findById(id).orElse(null));
        model.addAttribute("items", dao.findAll());
        model.addAttribute("mode", "EDIT");
        return "lab6/index";
    }

    @RequestMapping("/create")
    public String create(Category item) {
        dao.save(item);
        return "redirect:/category/index";
    }

    @RequestMapping("/update")
    public String update(Category item) {
        dao.save(item);
        return "redirect:/category/edit/" + item.getId();
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        dao.deleteById(id);
        return "redirect:/category/index";
    }
}