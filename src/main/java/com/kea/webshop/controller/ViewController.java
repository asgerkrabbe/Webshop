package com.kea.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String renderIndex() {
        return "index.html";
    }

    @GetMapping("/add-product")
    public String createProduct(){
        return "createproduct.html";
    }

}
