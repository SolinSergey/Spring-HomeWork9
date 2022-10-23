package ru.gb.homework9.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.homework9.entities.Product;
import ru.gb.homework9.repositories.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService() {
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }


    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> findProductByMoreMaxPrice(int maxPrice){
        return productRepository.findAllByMoreMaxPrice(maxPrice);
    }

    public List<Product> findProductByLessMaxPrice(int maxPrice){
        return productRepository.findAllByLessMaxPrice(maxPrice);
    }

    public List<Product> findProductByPriceBetween(int minPrice, int maxPrice){
        return productRepository.findProductByPriceBetween(minPrice,maxPrice);
    }

    public void saveProduct (Product product){
        productRepository.save(product);
    }
}
