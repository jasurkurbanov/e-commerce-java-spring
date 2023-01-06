package com.example.ecommercebackend.controller;

import com.example.ecommercebackend.entity.Product;
import com.example.ecommercebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(path = "/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }


    /* /api/v1/products?limit=5

    @GetMapping
    public List<Product> getAllProductsByLimit(@RequestParam(value = "limit") int limit){
        return  productService.getAllProductsByLimit(limit);
    }
    */

    /* /api/v1/products?sortName="desc"

        @GetMapping
        public List<Product> getAllProductsByLimit(@RequestParam(value = "limit") int limit){
            return  productService.getAllProductsByLimit(limit);
        }
    */

    @PostMapping(path = "/add")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping(path = "/update/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

}
