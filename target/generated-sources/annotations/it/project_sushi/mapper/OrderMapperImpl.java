package it.project_sushi.mapper;

import it.project_sushi.model.Order;
import it.project_sushi.model.OrderDetail;
import it.project_sushi.model.Product;
import it.project_sushi.model.dto.OrderDTO;
import it.project_sushi.model.dto.OrderDetailDTO;
import it.project_sushi.model.dto.ProductDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-08T14:14:04+0200",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId( order.getId() );
        orderDTO.setOrderDetails( orderDetailListToOrderDetailDTOList( order.getOrderDetails() ) );

        return orderDTO;
    }

    @Override
    public Order toEntity(OrderDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( dto.getId() );
        order.setOrderDetails( orderDetailDTOListToOrderDetailList( dto.getOrderDetails() ) );

        return order;
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

    protected OrderDetailDTO orderDetailToOrderDetailDTO(OrderDetail orderDetail) {
        if ( orderDetail == null ) {
            return null;
        }

        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();

        orderDetailDTO.setProduct( productToProductDTO( orderDetail.getProduct() ) );
        orderDetailDTO.setQuantity( orderDetail.getQuantity() );

        return orderDetailDTO;
    }

    protected List<OrderDetailDTO> orderDetailListToOrderDetailDTOList(List<OrderDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDetailDTO> list1 = new ArrayList<OrderDetailDTO>( list.size() );
        for ( OrderDetail orderDetail : list ) {
            list1.add( orderDetailToOrderDetailDTO( orderDetail ) );
        }

        return list1;
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

    protected OrderDetail orderDetailDTOToOrderDetail(OrderDetailDTO orderDetailDTO) {
        if ( orderDetailDTO == null ) {
            return null;
        }

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setProduct( productDTOToProduct( orderDetailDTO.getProduct() ) );
        orderDetail.setQuantity( orderDetailDTO.getQuantity() );

        return orderDetail;
    }

    protected List<OrderDetail> orderDetailDTOListToOrderDetailList(List<OrderDetailDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDetail> list1 = new ArrayList<OrderDetail>( list.size() );
        for ( OrderDetailDTO orderDetailDTO : list ) {
            list1.add( orderDetailDTOToOrderDetail( orderDetailDTO ) );
        }

        return list1;
    }
}
