package web.shop.lab6.bai1_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.shop.lab6.bai1_2.Repository.ProductDAO;
import web.shop.lab6.bai1_2.model.Product;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductDAO dao;

    @RequestMapping("/product/sort")
    public String sort(Model model,
                       @RequestParam(defaultValue = "price") String field,
                       @RequestParam(defaultValue = "asc") String dir) {

        Sort.Direction direction =
                dir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

        Sort sort = Sort.by(direction, field);

        model.addAttribute("items", dao.findAll(sort));
        model.addAttribute("field", field);
        model.addAttribute("dir", dir);

        return "lab6/sort";
    }
    @RequestMapping("/product/page")
    public String paginate(
            Model model,
            @RequestParam(defaultValue = "0") int p,
            @RequestParam(defaultValue = "id") String field,
            @RequestParam(defaultValue = "asc") String dir,
            @RequestParam(defaultValue = "5") int size
    ) {
        if (p < 0) p = 0;

        Sort.Direction direction =
                dir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

        Page<Product> page;

        // 👉 ALL
        if (size == -1) {
            List<Product> list = dao.findAll(Sort.by(direction, field));
            page = new PageImpl<>(
                    list,
                    PageRequest.of(0, list.size() == 0 ? 1 : list.size()),
                    list.size()
            );
        } else {
            Pageable pageable = PageRequest.of(p, size, Sort.by(direction, field));
            page = dao.findAll(pageable);
        }

        model.addAttribute("page", page);
        model.addAttribute("field", field);
        model.addAttribute("dir", dir);
        model.addAttribute("size", size);

        return "lab6/page";
    }
}

