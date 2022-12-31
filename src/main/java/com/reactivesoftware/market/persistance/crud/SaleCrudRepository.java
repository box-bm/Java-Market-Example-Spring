package com.reactivesoftware.market.persistance.crud;

import com.reactivesoftware.market.persistance.entity.Sale;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SaleCrudRepository extends CrudRepository<Sale, Integer> {
    Optional<List<Sale>> findByIdCustomer(String idCustomer);
}
