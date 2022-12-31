package com.reactivesoftware.market.persistance.mapper;

import com.reactivesoftware.market.domain.Purchase;
import com.reactivesoftware.market.domain.PurchaseItem;
import com.reactivesoftware.market.persistance.entity.Sale;
import com.reactivesoftware.market.persistance.entity.SalesProduct;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-31T11:27:42-0600",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class SaleMapperImpl implements SaleMapper {

    @Autowired
    private SaleItemMapper saleItemMapper;

    @Override
    public Purchase toPurchase(Sale sale) {
        if ( sale == null ) {
            return null;
        }

        Purchase purchase = new Purchase();

        if ( sale.getId() != null ) {
            purchase.setPurchaseId( sale.getId() );
        }
        purchase.setClientId( sale.getIdCustomer() );
        purchase.setItems( salesProductListToPurchaseItemList( sale.getProducts() ) );
        purchase.setDate( sale.getDate() );
        purchase.setPaymentMethod( sale.getPaymentMethod() );
        purchase.setComment( sale.getComment() );
        purchase.setStatus( sale.getStatus() );

        return purchase;
    }

    @Override
    public List<Purchase> toPurchases(List<Sale> sales) {
        if ( sales == null ) {
            return null;
        }

        List<Purchase> list = new ArrayList<Purchase>( sales.size() );
        for ( Sale sale : sales ) {
            list.add( toPurchase( sale ) );
        }

        return list;
    }

    @Override
    public Sale toSale(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        Sale sale = new Sale();

        sale.setId( purchase.getPurchaseId() );
        sale.setIdCustomer( purchase.getClientId() );
        sale.setProducts( purchaseItemListToSalesProductList( purchase.getItems() ) );
        sale.setDate( purchase.getDate() );
        sale.setPaymentMethod( purchase.getPaymentMethod() );
        sale.setComment( purchase.getComment() );
        sale.setStatus( purchase.getStatus() );

        return sale;
    }

    protected List<PurchaseItem> salesProductListToPurchaseItemList(List<SalesProduct> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseItem> list1 = new ArrayList<PurchaseItem>( list.size() );
        for ( SalesProduct salesProduct : list ) {
            list1.add( saleItemMapper.toPurchaseItem( salesProduct ) );
        }

        return list1;
    }

    protected List<SalesProduct> purchaseItemListToSalesProductList(List<PurchaseItem> list) {
        if ( list == null ) {
            return null;
        }

        List<SalesProduct> list1 = new ArrayList<SalesProduct>( list.size() );
        for ( PurchaseItem purchaseItem : list ) {
            list1.add( saleItemMapper.toSalesProduct( purchaseItem ) );
        }

        return list1;
    }
}
