package com.DigitalVision.service.services;

import com.DigitalVision.service.dtos.SearchDTO;
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

    public List<Product> getAllProducts(SearchDTO search){
        Set<Product> filteredProducts = new HashSet<>();

        if(search.getQuery() != null || search.getMinPrice() != 0 || search.getMaxPrice() != 0 || search.getCategory() != null){
            Set<Product> productsIncludingQuery = filterAllProductsBySearchQuery(search.getQuery());
            Set<Product> productsIncludedInPriceRange = filterAllProductsByPriceRange(search.getMinPrice(), search.getMaxPrice());
            Set<Product> productsByCategory = filterAllProductsByCategory(search.getCategory());
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
