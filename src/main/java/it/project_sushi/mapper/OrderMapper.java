package it.project_sushi.mapper;

import it.project_sushi.model.Order;
import it.project_sushi.model.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


<<<<<<< HEAD
@Mapper(componentModel = "spring")//uses = {ProductMapper.class,OrderDetailMapper.class})
public interface OrderMapper {
//	OrderMapper ISTANCE=Mappers.getMapper(OrderMapper.class);
	
//	@Mapping(target = "orderDetails", source = "orderDetails")
	OrderDTO toDto(Order order);
//	@Mapping(target = "product", ignore = true)
=======
@Mapper(componentModel = "spring",uses = {ProductMapper.class,OrderDetailMapper.class})
public interface OrderMapper {
	//OrderMapper ISTANCE=Mappers.getMapper(OrderMapper.class);
	
	//@Mapping(target = "orderDetails", source = "orderDetails")
	OrderDTO toDto(Order order);
	//@Mapping(target = "product", ignore = true)
>>>>>>> 8d33ba3b311f9e0fc6e6e3208a2f12b0241907d4
	Order toEntity(OrderDTO dto);
}
