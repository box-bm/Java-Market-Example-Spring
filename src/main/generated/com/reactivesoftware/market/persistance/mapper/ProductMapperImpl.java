package com.reactivesoftware.market.persistance.mapper;

import com.reactivesoftware.market.persistance.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-31T11:41:52-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public com.reactivesoftware.market.domain.Product toProduct(Product product) {
        if ( product == null ) {
            return null;
        }

        com.reactivesoftware.market.domain.Product product1 = new com.reactivesoftware.market.domain.Product();

        if ( product.getId() != null ) {
            product1.setProductId( product.getId() );
        }
        product1.setProduct( product.getName() );
        if ( product.getIdCategory() != null ) {
            product1.setCategoryId( product.getIdCategory() );
        }
        if ( product.getSalePrice() != null ) {
            product1.setPrice( product.getSalePrice() );
        }
        if ( product.getQuantityStock() != null ) {
            product1.setStock( product.getQuantityStock() );
        }
        if ( product.getStatus() != null ) {
            product1.setStatus( product.getStatus() );
        }
        product1.setCategory( categoryMapper.toCategory( product.getCategory() ) );

        return product1;
    }

    @Override
    public List<com.reactivesoftware.market.domain.Product> toProducts(List<Product> productList) {
        if ( productList == null ) {
            return null;
        }

        List<com.reactivesoftware.market.domain.Product> list = new ArrayList<com.reactivesoftware.market.domain.Product>( productList.size() );
        for ( Product product : productList ) {
            list.add( toProduct( product ) );
        }

        return list;
    }

    @Override
    public Product toProduct(com.reactivesoftware.market.domain.Product product) {
        if ( product == null ) {
            return null;
        }

        Product product1 = new Product();

        product1.setId( product.getProductId() );
        product1.setName( product.getProduct() );
        product1.setIdCategory( product.getCategoryId() );
        product1.setSalePrice( product.getPrice() );
        product1.setQuantityStock( product.getStock() );
        product1.setStatus( product.isStatus() );
        product1.setCategory( categoryMapper.toCategory( product.getCategory() ) );

        return product1;
    }
}
