package com.reactivesoftware.market.persistance;

import com.reactivesoftware.market.domain.Purchase;
import com.reactivesoftware.market.persistance.crud.SaleCrudRepository;
import com.reactivesoftware.market.persistance.entity.Sale;
import com.reactivesoftware.market.persistance.mapper.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SaleRepository implements com.reactivesoftware.market.domain.repositories.PurchaseRepository {
    @Autowired
    private SaleCrudRepository saleCrudRepository;
    @Autowired
    private SaleMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Sale>) saleCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String customerID) {
        return saleCrudRepository.findByIdCustomer(customerID).map(sales -> mapper.toPurchases(sales));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Sale sale = mapper.toSale(purchase);
        sale.getProducts().forEach(products -> products.setSale(sale));
        return mapper.toPurchase(saleCrudRepository.save(sale));
    }
}
