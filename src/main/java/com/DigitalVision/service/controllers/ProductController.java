package com.DigitalVision.service.controllers;

import com.DigitalVision.service.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller("api/v1/product")
public class ProductController {

    @PostMapping("/all")
    public  ResponseEntity<?> addProductList(@RequestBody List<Product> products){
         addProductList(products);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
