package com.DigitalVision.service.controllers;

import com.DigitalVision.service.dtos.SearchDTO;
import com.DigitalVision.service.models.Product;
import com.DigitalVision.service.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@AllArgsConstructor
public class ProductController {

    final ProductService productService;

    @PostMapping()
    public  ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product newProduct = productService.addNewProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping()
    public  ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product newProduct = productService.updateProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public  ResponseEntity<List<Product>> getAllProducts(String query){
        List<Product> products = productService.getAllProductsBySearchQuery(query);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/price-range/all")
    public  ResponseEntity<List<Product>> getAllProducts(double minPrice, double maxPrice){
        List<Product> products = productService.getAllProductsByPriceRange(minPrice, maxPrice);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/all")
    public  ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
