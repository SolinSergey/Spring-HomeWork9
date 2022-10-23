package ru.gb.homework9.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework9.entities.Product;
import ru.gb.homework9.services.ProductService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String findAll() {
        return productService.findAll().toString();
    }

    @GetMapping("/{id}")
    public Optional findById(@PathVariable Long id) {
        System.out.println(id);
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            return product;
        } else return Optional.empty();
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> deleteProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
