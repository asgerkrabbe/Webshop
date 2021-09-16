package com.kea.webshop.service;

import com.kea.webshop.model.Product;
import com.kea.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAll(){
        List<Product> productList = new ArrayList<>();

        for (Product p:productRepository.findAll()) {
            productList.add(p);
        }
        return productList;
    }

    public void editProduct(Product product) {
        productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
