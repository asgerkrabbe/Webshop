package com.kea.webshop.controller;

import com.kea.webshop.model.Product;
import com.kea.webshop.repository.ProductRepository;
import com.kea.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class ProductController {

    Product product;

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("products", productService.findAll());

        return "index.html";
    }

    @GetMapping("/product")
    public String inspectProduct(@RequestParam long id) {
        productService.findById(id);

        return "product.html";
    }

    @PostMapping("/update-product")
    public String updateProduct(@RequestParam long id, WebRequest request) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");

        Product product = new Product(id, name, Integer.parseInt(price));
        productService.editProduct(product);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam long id) {
        productService.delete(id);

    return "redirect:/";
    }




}
