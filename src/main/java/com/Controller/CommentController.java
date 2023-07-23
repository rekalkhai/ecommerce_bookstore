package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Entity.Comment;
import com.Entity.Product;
import com.Entity.User;
import com.Service.CommentService;
import com.Service.ProductService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class CommentController {
    @Autowired
    ProductService productService;
    
    @Autowired
    CommentService commentService;
    
    @PostMapping("/comment")
    public String postComment(Model model,HttpSession session ,
    		@RequestParam("comment") String comment,
    		@RequestParam("productID") int productID) {
    	Comment comment2=new Comment();
    	User user=null;
    	Object o=session.getAttribute("NAME");
    	if(o!=null) {
    		user=(User) o;
    		Product product=productService.getProductById(productID);
    		comment2.setCm(comment);
    		comment2.setProduct(product);
    		comment2.setUser(user);
    		commentService.addComment(comment2);
    		return "redirect:/detail/" + Integer.toString(productID);
    	}
    	else {
            return "redirect:/Login";
        }
    }
}
