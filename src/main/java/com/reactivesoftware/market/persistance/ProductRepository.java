package com.reactivesoftware.market.persistance;

import com.reactivesoftware.market.persistance.crud.ProductCrudRepository;
import com.reactivesoftware.market.persistance.entity.Product;

import java.util.List;

public class ProductRepository {
    private ProductCrudRepository productoCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productoCrudRepository.findAll();
    }
}
