package com.reactivesoftware.market.persistance.mapper;

import com.reactivesoftware.market.domain.PurchaseItem;
import com.reactivesoftware.market.persistance.entity.SalesProduct;
import com.reactivesoftware.market.persistance.entity.SalesProductPK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-31T17:22:29-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class SaleItemMapperImpl implements SaleItemMapper {

    @Override
    public PurchaseItem toPurchaseItem(SalesProduct product) {
        if ( product == null ) {
            return null;
        }

        PurchaseItem purchaseItem = new PurchaseItem();

        Integer productId = productPkProductId( product );
        if ( productId != null ) {
            purchaseItem.setProductId( productId );
        }
        if ( product.getStatus() != null ) {
            purchaseItem.setActive( product.getStatus() );
        }
        if ( product.getQuantity() != null ) {
            purchaseItem.setQuantity( product.getQuantity() );
        }
        if ( product.getTotal() != null ) {
            purchaseItem.setTotal( product.getTotal() );
        }

        return purchaseItem;
    }

    @Override
    public SalesProduct toSalesProduct(PurchaseItem item) {
        if ( item == null ) {
            return null;
        }

        SalesProduct salesProduct = new SalesProduct();

        salesProduct.setPk( purchaseItemToSalesProductPK( item ) );
        salesProduct.setStatus( item.isActive() );
        salesProduct.setQuantity( item.getQuantity() );
        salesProduct.setTotal( item.getTotal() );

        return salesProduct;
    }

    private Integer productPkProductId(SalesProduct salesProduct) {
        if ( salesProduct == null ) {
            return null;
        }
        SalesProductPK pk = salesProduct.getPk();
        if ( pk == null ) {
            return null;
        }
        Integer productId = pk.getProductId();
        if ( productId == null ) {
            return null;
        }
        return productId;
    }

    protected SalesProductPK purchaseItemToSalesProductPK(PurchaseItem purchaseItem) {
        if ( purchaseItem == null ) {
            return null;
        }

        SalesProductPK salesProductPK = new SalesProductPK();

        salesProductPK.setProductId( purchaseItem.getProductId() );

        return salesProductPK;
    }
}
