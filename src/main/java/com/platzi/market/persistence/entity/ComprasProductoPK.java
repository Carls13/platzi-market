package com.platzi.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.math.BigInteger;

@Embeddable
public class ComprasProductoPK {

    @Column(name = "id_compra")
    private BigInteger idCompra;

    @Column(name = "id_producto")
    private Integer idProducto;

    public BigInteger getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(BigInteger idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
