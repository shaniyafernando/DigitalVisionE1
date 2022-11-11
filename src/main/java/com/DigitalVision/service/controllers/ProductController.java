package com.DigitalVision.service.controllers;

import com.DigitalVision.service.dtos.ProductDTO;
import com.DigitalVision.service.models.Product;
import com.DigitalVision.service.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller("api/v1/product")
@AllArgsConstructor
public class ProductController {

    final ProductService productService;

    @PostMapping()
    public  ResponseEntity<Product> addProductList(@RequestBody ProductDTO product){
        Product newProduct = productService.addNewProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping("all")
    public  ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
