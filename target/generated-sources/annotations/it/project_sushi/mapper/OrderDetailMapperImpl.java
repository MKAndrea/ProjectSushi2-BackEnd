package it.project_sushi.mapper;

import it.project_sushi.model.OrderDetail;
import it.project_sushi.model.dto.OrderDetailDTO;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-23T17:07:32+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
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
