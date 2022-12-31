package com.reactivesoftware.market.persistance.mapper;

import com.reactivesoftware.market.domain.PurchaseItem;
import com.reactivesoftware.market.persistance.entity.SalesProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface SaleItemMapper {
    @Mappings({
            @Mapping(source = "pk.productId", target = "productId"),
            @Mapping(source = "status", target = "active")
    })
    PurchaseItem toPurchaseItem(SalesProduct product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "sale", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "pk.saleId", ignore = true)
    })
    SalesProduct toSalesProduct(PurchaseItem item);
}
