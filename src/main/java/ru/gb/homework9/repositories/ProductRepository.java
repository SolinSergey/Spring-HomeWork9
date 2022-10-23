package ru.gb.homework9.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.gb.homework9.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select p from Product p where p.price>:maxPrice")
    List<Product> findAllByMoreMaxPrice (int maxPrice);

    @Query("select p from Product p where p.price<:maxPrice")
    List<Product> findAllByLessMaxPrice (int maxPrice);

    List<Product> findProductByPriceBetween(int minPrice, int maxPrice);
}
