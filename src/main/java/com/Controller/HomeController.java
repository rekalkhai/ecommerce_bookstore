package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Entity.Order;
import com.Service.CategoryService;
import com.Service.CommentService;
import com.Service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    CommentService commentService;
    
    @GetMapping("/home")
    public String getHome(Model model) {
    	model.addAttribute("products", productService.getProducts());
    	model.addAttribute("categories", categoryService.getCategorys());
    	model.addAttribute("lastProduct", productService.getLastProduct());
    	return "Home";
    }
    @GetMapping("/category/{cid}")
    public String getCategory(@PathVariable("cid") int cid ,Model model) {
    	model.addAttribute("products", productService.getProductByCate(categoryService.getCategoryById(cid).getCid()));
    	model.addAttribute("categories", categoryService.getCategorys());
    	model.addAttribute("lastProduct", productService.getLastProduct());
    	return "Home";
    }

    @GetMapping("/detail/{id}")
    public String getDetail(Model model , @PathVariable("id") int id, HttpSession session) {
    	model.addAttribute("order", new Order());
    	model.addAttribute("product", productService.getProductById(id));
    	model.addAttribute("comments",commentService.cmFindByProductID(id));
    	return "Detail";
    }
}