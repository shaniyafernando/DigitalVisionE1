package com.DigitalVision.service.services;

import com.DigitalVision.service.dtos.ProductDTO;
import com.DigitalVision.service.models.Product;
import com.DigitalVision.service.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class ProductService {

    final ProductRepository productRepository;

    public Product addNewProduct(ProductDTO product){
        Product newProduct = new Product();

        String convertIntoCurrency = newProduct.formatPrice(product.getPrice());


        newProduct.setTitle(product.getTitle());
        newProduct.setDescription(product.getDescription());
        newProduct.setCategory(product.getCategory());
        newProduct.setBrand(product.getBrand());
        newProduct.setColour(product.getColour());
        newProduct.setPrice(convertIntoCurrency);
        newProduct.setQuantity(product.getQuantity());

        String[] images = product.getImages();

        if(images.length == 5){
            newProduct.setImages(product.getImages());
        }

        return productRepository.save(newProduct);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}
