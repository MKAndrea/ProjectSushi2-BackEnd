package it.project_sushi.mapper;

import it.project_sushi.model.OrderDetail;
import it.project_sushi.model.dto.OrderDetailDTO;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-08T15:26:15+0200",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.41.0.v20250213-1140, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class OrderDetailMapperImpl implements OrderDetailMapper {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public OrderDetail toEntity(OrderDetailDTO dto) {
        if ( dto == null ) {
            return null;
        }

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setProduct( productMapper.toEntity( dto.getProduct() ) );
        orderDetail.setQuantity( dto.getQuantity() );

        return orderDetail;
    }
}
