package com.DigitalVision.service.services;

import com.DigitalVision.service.dtos.ProductDTO;
import com.DigitalVision.service.models.Product;
import com.DigitalVision.service.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class ProductService {

    final ProductRepository productRepository;

    public Product addNewProduct(ProductDTO product){
        Product newProduct = new Product();

        newProduct.setTitle(product.getTitle());
        newProduct.setDescription(product.getDescription());
        newProduct.setCategory(product.getCategory());
        newProduct.setBrand(product.getBrand());
        newProduct.setColour(product.getColour());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantity(product.getQuantity());

        String[] images = product.getImages();

        if(images.length == 5){
            newProduct.setImages(product.getImages());
        }

        return productRepository.save(newProduct);
    }

    public List<Product> getAllProducts(String query, double minPrice, double maxPrice, String category){
        Set<Product> filteredProducts = new HashSet<>();

        if(query != null || minPrice != 0 || maxPrice != 0 || category != null){
            Set<Product> productsIncludingQuery = filterAllProductsBySearchQuery(query);
            Set<Product> productsIncludedInPriceRange = filterAllProductsByPriceRange(minPrice, maxPrice);
            Set<Product> productsByCategory = filterAllProductsByCategory(category);
            filteredProducts.addAll(productsByCategory);
            filteredProducts.addAll(productsIncludingQuery);
            filteredProducts.addAll(productsIncludedInPriceRange);

            return filteredProducts.stream().toList();
        }
        return productRepository.findAll();
    }


    public Set<Product> filterAllProductsBySearchQuery(String query){
        Set<Product> productsIncludingSearchQuery = new HashSet<>();
        List<Product> products = productRepository.findAll();
        products.stream().filter(product ->
                product.getTitle().contains(query) ||
                product.getDescription().contains(query)||
                product.getColour().contains(query)||
                product.getBrand().contains(query)).forEach(
                productsIncludingSearchQuery::add
        );
        return productsIncludingSearchQuery;
    }

    public Set<Product> filterAllProductsByPriceRange(double minPrice, double maxPrice){
        Set<Product> productsIncludedInPriceRange = new HashSet<>();
        List<Product> products = productRepository.findAll();
        products.stream().filter(product ->
                product.getPrice() >= minPrice && product.getPrice() <= maxPrice )
                .forEach(productsIncludedInPriceRange::add);
        return productsIncludedInPriceRange;
    }

    public Set<Product> filterAllProductsByCategory(String category){
        Set<Product> productsByCategory = new HashSet<>();
        List<Product> products = productRepository.findAll();
        products.stream().filter(product -> product.getCategory().contains(category))
                .forEach(productsByCategory::add);
        return productsByCategory;
    }
}
