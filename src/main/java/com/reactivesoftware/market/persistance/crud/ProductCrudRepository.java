package com.reactivesoftware.market.persistance.crud;

import com.reactivesoftware.market.persistance.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
}
