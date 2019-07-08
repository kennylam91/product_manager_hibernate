package com.codegym.pms.controller;

import com.codegym.pms.model.Category;
import com.codegym.pms.service.CategoryService;
import com.codegym.pms.service.ProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("")
    public ModelAndView listCategories(){
        ModelAndView modelAndView=new ModelAndView("/category/list");
        modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category",new Category());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/view")
    public ModelAndView showProducts(@RequestParam Long id){
        ModelAndView modelAndView = new ModelAndView("/category/view");
        Category category = categoryService.findById(id);
        modelAndView.addObject("category",category);
        modelAndView.addObject("products",productService.findAllByCategory(category));
        return modelAndView;
    }
}
