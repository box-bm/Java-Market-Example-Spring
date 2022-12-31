package com.reactivesoftware.market.persistance.crud;

import com.reactivesoftware.market.persistance.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ? ORDER BY name asc", nativeQuery = true)
    List<Product> findByIdCategoryOrderByNameASC(int idCategory);

    Optional<List<Product>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
