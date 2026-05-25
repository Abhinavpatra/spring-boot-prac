package com.example.createstore.services;
import com.example.createstore.entities.Product;
import com.example.createstore.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public Product createProduct(Product p){
        return productRepository.save(p);
    }

    public List<Product> readProducts(){
        return productRepository.findAll();
    }

    public Product readProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product does not exist, with id: " + id));
    }

    public Product updateProduct(Long id, Product newProduct){
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found with id : " + id));
        existingProduct.setName(newProduct.getName());
        existingProduct.setCategory(newProduct.getCategory());
        existingProduct.setPrice(newProduct.getPrice());
        existingProduct.setDescription(newProduct.getDescription());
        existingProduct.setStockQuantity(newProduct.getStockQuantity());

        return productRepository.save(existingProduct);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
        System.out.println("User deleted, with id: " +id);
    }
}
