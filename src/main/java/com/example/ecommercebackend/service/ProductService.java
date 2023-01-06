package com.example.ecommercebackend.service;

import com.example.ecommercebackend.entity.Product;
import com.example.ecommercebackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    /*@PersistenceContext
    private EntityManager entityManager;
*/
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).get();
    }
    /*public List<Product> getAllProductsByLimit(int limit){
            return entityManager.createQuery("SELECT p FROM Product p", Product.class).setMaxResults(limit).getResultList();
    }*/
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(int id, Product product) {
        Product productFound = productRepository.findById(id).get();
        productFound.setName(product.getName());
        productFound.setImageUrl(product.getImageUrl());
        productFound.setPrice(product.getPrice());
        productFound.setDescription(product.getDescription());
        return productRepository.save(productFound);
    }


    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "deleted product:" + id;
    }

}
