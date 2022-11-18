package com.DigitalVision.service.services;
import com.DigitalVision.service.models.Product;
import com.DigitalVision.service.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    public Product addNewProduct(Product product){
        Product newProduct = new Product();

        newProduct.setTitle(product.getTitle());
        newProduct.setDescription(product.getDescription());
        newProduct.setImage(product.getImage());
        newProduct.setCategory(product.getCategory());
        newProduct.setBrand(product.getBrand());
        newProduct.setColour(product.getColour());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantity(product.getQuantity());

        return productRepository.save(newProduct);
    }

    public Product updateProduct(Product updatedProduct){
        Product product = productRepository.getReferenceById(updatedProduct.getId());

        product.setTitle(updatedProduct.getTitle());
        product.setDescription(updatedProduct.getDescription());
        product.setImage(updatedProduct.getImage());
        product.setBrand(updatedProduct.getBrand());
        product.setColour(updatedProduct.getColour());
        product.setCategory(updatedProduct.getCategory());
        product.setPrice(updatedProduct.getPrice());
        product.setQuantity(updatedProduct.getQuantity());

        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getAllProductsBySearchQuery(String query){
        List<Product> productsIncludingSearchQuery = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        products.stream().filter(product ->
                product.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                product.getDescription().toLowerCase().contains(query.toLowerCase())||
                product.getColour().toLowerCase().contains(query.toLowerCase())||
                product.getBrand().toLowerCase().contains(query.toLowerCase())||
                product.getCategory().toLowerCase().contains(query.toLowerCase())).forEach(
                productsIncludingSearchQuery::add
        );
        return productsIncludingSearchQuery;
    }

    public List<Product> getAllProductsByPriceRange(double minPrice, double maxPrice){
        List<Product> productsIncludedInPriceRange = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        products.stream().filter(product ->
                product.getPrice() >= minPrice && product.getPrice() <= maxPrice )
                .forEach(productsIncludedInPriceRange::add);
        return productsIncludedInPriceRange;
    }

}
