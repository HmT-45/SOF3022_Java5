package web.shop.lab6va7.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.shop.lab6va7.Repository.ProductDAO;
import web.shop.lab6va7.model.Product;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductSearchController {

    @Autowired
    ProductDAO dao;

    @Autowired
    HttpSession session;

    // ===== BÀI 1: SEARCH BY PRICE =====
    @RequestMapping("/product/search")
    public String search(Model model,
                         @RequestParam("min") Optional<Double> min,
                         @RequestParam("max") Optional<Double> max) {

        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);

        List<Product> items = dao.findByPrice(minPrice, maxPrice);
        model.addAttribute("items", items);

        return "lab6/search";
    }

    // ===== BÀI 2: SEARCH + PAGE =====
    @RequestMapping("/product/search-and-page")
    public String searchAndPage(Model model,
                                @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p) {

        String keywords = kw.orElse((String) session.getAttribute("keywords"));
        if (keywords == null) keywords = "";
        session.setAttribute("keywords", keywords);

        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page =
                dao.findByKeywords("%" + keywords + "%", pageable);

        model.addAttribute("page", page);
        model.addAttribute("keywords", keywords);
        return "lab6/search-and-page";
    }
}