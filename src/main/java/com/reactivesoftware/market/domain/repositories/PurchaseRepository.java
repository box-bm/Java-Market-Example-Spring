package com.reactivesoftware.market.domain.repositories;

import com.reactivesoftware.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String customerID);
    Purchase save(Purchase purchase);

}
