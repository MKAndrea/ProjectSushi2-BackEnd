package it.project_sushi.mapper;

import it.project_sushi.model.Order;
import it.project_sushi.model.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring",uses = {ProductMapper.class,OrderDetailMapper.class})
public interface OrderMapper {
	OrderMapper ISTANCE=Mappers.getMapper(OrderMapper.class);
	
	@Mapping(target = "orderDetails", source = "orderDetails")
	OrderDTO toDto(Order order);
	Order toEntity(OrderDTO dto);
}
