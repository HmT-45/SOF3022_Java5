package web.shop.lab6va7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.shop.lab6va7.Repository.ProductDAO;
import web.shop.lab6va7.model.Product;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductDAO dao;

    // SORT
    @RequestMapping("/product/sort")
    public String sort(Model model,
                       @RequestParam("field") Optional<String> field) {

        Sort sort = Sort.by(Sort.Direction.DESC, field.orElse("price"));
        List<Product> items = dao.findAll(sort);

        model.addAttribute("items", items);
        model.addAttribute("field", field.orElse("price").toUpperCase());
        return "lab6/sort";
    }

    // PAGE
    @RequestMapping("/product/page")
    public String paginate(Model model,
                           @RequestParam("p") Optional<Integer> p) {

        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = dao.findAll(pageable);

        model.addAttribute("page", page);
        return "lab6/page";
    }
}