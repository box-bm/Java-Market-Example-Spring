package com.reactivesoftware.market.persistance;

import com.reactivesoftware.market.persistance.crud.ProductCrudRepository;
import com.reactivesoftware.market.domain.Product;
import com.reactivesoftware.market.persistance.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements com.reactivesoftware.market.domain.repositories.ProductRepository {
    private ProductCrudRepository productCrudRepository;
    private ProductMapper mapper;

    public List<Product> getAll() {
        List<com.reactivesoftware.market.persistance.entity.Product> products = (List<com.reactivesoftware.market.persistance.entity.Product>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryID) {
        List<com.reactivesoftware.market.persistance.entity.Product> products = productCrudRepository.findByIdCategoryOrderByNameASC(categoryID);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<Product>> getInsufficientProducts(int quantity) {
        Optional<List<com.reactivesoftware.market.persistance.entity.Product>> products = productCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return products.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int id) {
        return productCrudRepository.findById(id).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        com.reactivesoftware.market.persistance.entity.Product prod = mapper.toProduct(product);
        return mapper.toProduct(productCrudRepository.save(prod));
    }

    public void delete(int id) {
        productCrudRepository.deleteById(id);
    }
}
