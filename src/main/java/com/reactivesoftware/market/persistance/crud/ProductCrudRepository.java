package com.reactivesoftware.market.persistance.crud;

import com.reactivesoftware.market.persistance.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    List<Product> findByIdCategoryOrderByNameAsc(int idCategory);

    Optional<List<Product>> findByQuantityStockLessThanAndStatus(int quantityStock, boolean status);
}
