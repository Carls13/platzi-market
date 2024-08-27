package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.Producto;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-26T21:42:03-0400",
    comments = "version: 1.6.0, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.8.jar, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Product toProduct(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        Product product = new Product();

        if ( producto.getIdProducto() != null ) {
            product.setProductId( producto.getIdProducto().intValue() );
        }
        product.setName( producto.getNombre() );
        if ( producto.getIdCategoria() != null ) {
            product.setCategoryId( producto.getIdCategoria().intValue() );
        }
        if ( producto.getPrecioVenta() != null ) {
            product.setPrice( producto.getPrecioVenta() );
        }
        if ( producto.getCantidadStock() != null ) {
            product.setStock( producto.getCantidadStock().intValue() );
        }
        if ( producto.getEstado() != null ) {
            product.setActive( producto.getEstado() );
        }
        product.setCategory( categoryMapper.toCategory( producto.getCategoria() ) );

        return product;
    }

    @Override
    public List<Product> toProducts(List<Producto> productos) {
        if ( productos == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productos.size() );
        for ( Producto producto : productos ) {
            list.add( toProduct( producto ) );
        }

        return list;
    }

    @Override
    public Producto toProducto(Product product) {
        if ( product == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setIdProducto( BigInteger.valueOf( product.getProductId() ) );
        producto.setNombre( product.getName() );
        producto.setIdCategoria( BigInteger.valueOf( product.getCategoryId() ) );
        producto.setPrecioVenta( product.getPrice() );
        producto.setCantidadStock( BigInteger.valueOf( product.getStock() ) );
        producto.setEstado( product.isActive() );
        producto.setCategoria( categoryMapper.toCategoria( product.getCategory() ) );

        return producto;
    }
}
