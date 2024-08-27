package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseItem;
import com.platzi.market.persistence.entity.ComprasProducto;
import com.platzi.market.persistence.entity.ComprasProductoPK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-26T21:42:04-0400",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class PurchaseItemMapperImpl implements PurchaseItemMapper {

    @Override
    public PurchaseItem toPurchaseItem(ComprasProducto producto) {
        if ( producto == null ) {
            return null;
        }

        PurchaseItem purchaseItem = new PurchaseItem();

        Integer idProducto = productoIdIdProducto( producto );
        if ( idProducto != null ) {
            purchaseItem.setProductId( idProducto );
        }
        if ( producto.getCantidad() != null ) {
            purchaseItem.setQuantity( producto.getCantidad() );
        }
        if ( producto.getEstado() != null ) {
            purchaseItem.setActive( producto.getEstado() );
        }
        if ( producto.getTotal() != null ) {
            purchaseItem.setTotal( producto.getTotal() );
        }

        return purchaseItem;
    }

    @Override
    public ComprasProducto toComprasProducto(PurchaseItem item) {
        if ( item == null ) {
            return null;
        }

        ComprasProducto comprasProducto = new ComprasProducto();

        comprasProducto.setId( purchaseItemToComprasProductoPK( item ) );
        comprasProducto.setCantidad( item.getQuantity() );
        comprasProducto.setEstado( item.isActive() );
        comprasProducto.setTotal( item.getTotal() );

        return comprasProducto;
    }

    private Integer productoIdIdProducto(ComprasProducto comprasProducto) {
        ComprasProductoPK id = comprasProducto.getId();
        if ( id == null ) {
            return null;
        }
        return id.getIdProducto();
    }

    protected ComprasProductoPK purchaseItemToComprasProductoPK(PurchaseItem purchaseItem) {
        if ( purchaseItem == null ) {
            return null;
        }

        ComprasProductoPK comprasProductoPK = new ComprasProductoPK();

        comprasProductoPK.setIdProducto( purchaseItem.getProductId() );

        return comprasProductoPK;
    }
}
