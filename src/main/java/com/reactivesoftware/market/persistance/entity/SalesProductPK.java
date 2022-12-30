package com.reactivesoftware.market.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class SalesProductPK implements Serializable {
    @Column(name = "id_compra")
    private Integer saleID;
    @Column(name = "id_producto")
    private Integer productID;


}
