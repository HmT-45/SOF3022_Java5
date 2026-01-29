package web.shop.lab6va7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.shop.lab6va7.Repository.ProductDAO;
import web.shop.lab6va7.dto.Report;

import java.util.List;

@Controller
public class ReportController {

    @Autowired
    ProductDAO dao;

    @RequestMapping("/report/inventory-by-category")
    public String inventory(Model model) {

        List<Report> items = dao.getInventoryByCategory();
        model.addAttribute("items", items);

        return "lab6/inventory-by-category";
    }
}