package com.reactivesoftware.market.persistance.mapper;

import com.reactivesoftware.market.domain.Purchase;
import com.reactivesoftware.market.persistance.entity.Sale;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SaleItemMapper.class})
public interface SaleMapper {
    @Mappings({
            @Mapping(source = "id", target = "purchaseId"),
            @Mapping(source = "idCustomer", target = "clientId"),
            @Mapping(source = "products", target = "items")
    })
    Purchase toPurchase(Sale sale);
    List<Purchase> toPurchases(List<Sale> sales);

    @InheritInverseConfiguration
    @Mapping(target = "customer", ignore = true)
    Sale toSale(Purchase purchase);

}
