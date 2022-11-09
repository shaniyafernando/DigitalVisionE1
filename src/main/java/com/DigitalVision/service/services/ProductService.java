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

    public void addNewProduct(ProductDTO product){
        Product newProduct = new Product();

        String convertIntoCurrency = newProduct.formatPrice(product.getPrice());

        newProduct.setImages(product.getImages());
        newProduct.setTitle(product.getTitle());
        newProduct.setDescription(product.getDescription());
        newProduct.setBrand(product.getBrand());
        newProduct.setColour(product.getColour());
        newProduct.setPrice(convertIntoCurrency);
        newProduct.setQuantity(product.getQuantity());

        productRepository.save(newProduct);
    }

    public void addProductList(List<ProductDTO> productList){
        for (ProductDTO product: productList) {
            addNewProduct(product);
        }
    }

}
