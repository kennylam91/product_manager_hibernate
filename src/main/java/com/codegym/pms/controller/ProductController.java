package com.codegym.pms.controller;

import com.codegym.pms.model.Product;
import com.codegym.pms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/create")
    public ModelAndView getCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView createNewProduct(@ModelAttribute Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }

    @GetMapping
    public ModelAndView showList(){
        List<Product> productList= productService.findAll();
        ModelAndView modelAndView= new ModelAndView("list");
        modelAndView.addObject("productList",productList);
        return modelAndView;
    }
}
