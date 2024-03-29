package com.codegym.pms.controller;

import com.codegym.pms.model.Category;
import com.codegym.pms.model.Product;
import com.codegym.pms.service.CategoryService;
import com.codegym.pms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/create")
    public ModelAndView getCreateForm(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView createNewProduct(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("categories",categoryService.findAll());
            return modelAndView;
        } else {
            productService.save(product);
            ModelAndView modelAndView = new ModelAndView("redirect:/product");
            return modelAndView;
        }
    }

    @GetMapping
    public ModelAndView showList(@RequestParam("productSearch") Optional<String> productSearch, Pageable pageable) {
        Page<Product> productList;
        if(productSearch.isPresent()){
            productList= productService.findAllByNameContaining(productSearch.get(),pageable);
        }
        else {
            productList=productService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        productService.remove(id);
        return "redirect:/product";
    }

//    @ModelAttribute
//    public void addCategories(Model model){
//        model.addAttribute("categories", categoryService.findAll());
//    }

}
