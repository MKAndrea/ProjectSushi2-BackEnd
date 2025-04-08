package it.project_sushi.mapper;

import it.project_sushi.model.OrderDetail;
import it.project_sushi.model.Product;
import it.project_sushi.model.dto.OrderDetailDTO;
import it.project_sushi.model.dto.ProductDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-08T14:14:04+0200",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class OrderDetailMapperImpl implements OrderDetailMapper {

    @Override
    public OrderDetailDTO toDto(OrderDetail detail) {
        if ( detail == null ) {
            return null;
        }

        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();

        orderDetailDTO.setProduct( productToProductDTO( detail.getProduct() ) );
        orderDetailDTO.setQuantity( detail.getQuantity() );

        return orderDetailDTO;
    }

    @Override
    public OrderDetail toEntity(OrderDetailDTO dto) {
        if ( dto == null ) {
            return null;
        }

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setProduct( productDTOToProduct( dto.getProduct() ) );
        orderDetail.setQuantity( dto.getQuantity() );

        return orderDetail;
    }

    protected ProductDTO productToProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setDescription( product.getDescription() );
        productDTO.setId( product.getId() );
        productDTO.setIngredients( product.getIngredients() );
        productDTO.setName( product.getName() );
        productDTO.setPrice( product.getPrice() );
        productDTO.setProductImage( product.getProductImage() );

        return productDTO;
    }

    protected Product productDTOToProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setDescription( productDTO.getDescription() );
        product.setId( productDTO.getId() );
        product.setIngredients( productDTO.getIngredients() );
        product.setName( productDTO.getName() );
        product.setPrice( productDTO.getPrice() );
        product.setProductImage( productDTO.getProductImage() );

        return product;
    }
}
