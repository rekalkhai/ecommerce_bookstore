package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Entity.Product;
import com.Interface.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> getProducts(){
        return repo.findAll();
    }

    public List<Product> getProductByCate(Integer id) { return repo.getProductByCategory_cid(id);}

    public Product getProductById(Integer id) { return  repo.findById(id).get(); }
    public Product getLastProduct(){
        List<Product> product=repo.findAll(Sort.by(Sort.Direction.DESC,"id"));
        if(product.isEmpty()){
            return null;
        }
        else{
            return product.get(0);
        }
    }
    public void deleteProduct(Integer id){
        repo.deleteById(id);
    }

    public void addProduct(Product product){
        repo.save(product);
    }

}