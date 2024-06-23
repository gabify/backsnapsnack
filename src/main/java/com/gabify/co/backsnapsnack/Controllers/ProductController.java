package com.gabify.co.backsnapsnack.Controllers;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.gabify.co.backsnapsnack.Model.Product;
import com.gabify.co.backsnapsnack.Repo.ProductRepository;
import com.gabify.co.backsnapsnack.NotFoundException.ProductNotFoundException;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepo;

    ProductController(ProductRepository productRepository){
        this.productRepo = productRepository;
    }

    //http://localhost:8080/products
    //Return all products
    @GetMapping("/products")
    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    //http://localhost:8080/product/25
    //Return one product
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id){
        return productRepo.findById(id)
        .orElseThrow(() -> new ProductNotFoundException(id));
    }

    //http://localhost:8080/product/new
    //Create new product
    @PostMapping("/product/new")
    public String createProduct(@RequestBody Product product){
        productRepo.save(product);
        return "New product created! Yey!";
    }

    //http://localhost:8080/product/edit/1
    //Update existing product
    @PutMapping("/product/edit/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Product newProduct){
        productRepo.findById(id)
        .map(product ->{
            product.setName(newProduct.getName());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            product.setAvailable(newProduct.isAvailable());
            return productRepo.save(product);
        }).orElseGet(() ->{
            return productRepo.save(newProduct);
        });

        return "Product has been updated.";

    }

    //http://localhost:8080/product/delete/1
    //Delete product
    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productRepo.deleteById(id);
        return "Product deleted successfully";
    }
}
