package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Entity.Order;
import com.Entity.Product;
import com.Entity.User;
import com.Service.OrderService;
import com.Service.ProductService;
import com.Service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;
    @GetMapping("/cart")
    public String getCart(Model model, HttpSession session){
        User user=(User) session.getAttribute("NAME");
        List<Order> orders=orderService.findByCustomerID(user.getUserID());
        double total=0;
        for(Order tmp:orders){
            total+=tmp.getQuantity()*tmp.getProduct().getPrice();
        }
        model.addAttribute("orders",orders);
        model.addAttribute("total",total);
        model.addAttribute("count",orders.size());
        return "Cart";
    }
    @PostMapping("/bynow")
    public String getBynow(Model model, @RequestParam("quantity") int quantity,
                           @RequestParam("customerID") int customerID,
                           @RequestParam("productID") int productID){
        Order order=new Order();
        Product product=productService.getProductById(productID);
        order.setQuantity(quantity);
        order.setUser(userService.getUserByID(customerID));
        order.setProduct(product);
        orderService.addOrder(order);
        product.setSold(product.getSold()+quantity);
        productService.addProduct(product);
        model.addAttribute("orders",orderService.findByCustomerID(customerID));
        return "redirect:/cart";
    }

    @GetMapping("/delete/{oid}")
    public String getDeleteCart(Model model,@PathVariable("oid") int oid){
        orderService.deleteOrderById(oid);
        return "redirect:/cart";
    }

}