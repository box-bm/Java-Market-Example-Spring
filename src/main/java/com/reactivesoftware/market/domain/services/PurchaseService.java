package com.reactivesoftware.market.domain.services;

import com.reactivesoftware.market.domain.Purchase;
import com.reactivesoftware.market.domain.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String customerID) {
        return purchaseRepository.getByClient(customerID);
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

}
