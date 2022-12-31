package com.reactivesoftware.market.persistance.mapper;

import com.reactivesoftware.market.domain.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "id", target = "productId"),
            @Mapping(source = "name", target = "product"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "quantityStock", target = "stock"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "category", target = "category"),
    })
    Product toProduct(com.reactivesoftware.market.persistance.entity.Product product);

    List<Product> toProducts(List<com.reactivesoftware.market.persistance.entity.Product> productList);
    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    com.reactivesoftware.market.persistance.entity.Product toProduct(Product product);
}
