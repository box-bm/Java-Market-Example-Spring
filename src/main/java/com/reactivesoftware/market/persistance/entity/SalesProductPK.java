package com.reactivesoftware.market.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class SalesProductPK implements Serializable {
    @Column(name = "id_compra")
    private Integer saleId;
    @Column(name = "id_producto")
    private Integer productId;

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
