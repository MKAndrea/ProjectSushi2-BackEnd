package it.project_sushi.mapper;

import it.project_sushi.model.Order;
import it.project_sushi.model.OrderDetail;
import it.project_sushi.model.dto.OrderDTO;
import it.project_sushi.model.dto.OrderDetailDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-23T17:07:32+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDTO toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setOrderDetails( orderDetailListToOrderDetailDTOList( order.getOrderDetails() ) );
        orderDTO.setId( order.getId() );

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

    protected List<OrderDetailDTO> orderDetailListToOrderDetailDTOList(List<OrderDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDetailDTO> list1 = new ArrayList<OrderDetailDTO>( list.size() );
        for ( OrderDetail orderDetail : list ) {
            list1.add( orderDetailMapper.toDto( orderDetail ) );
        }

        return list1;
    }

    protected List<OrderDetail> orderDetailDTOListToOrderDetailList(List<OrderDetailDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderDetail> list1 = new ArrayList<OrderDetail>( list.size() );
        for ( OrderDetailDTO orderDetailDTO : list ) {
            list1.add( orderDetailMapper.toEntity( orderDetailDTO ) );
        }

        return list1;
    }
}
