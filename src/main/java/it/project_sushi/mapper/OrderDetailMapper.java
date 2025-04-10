package it.project_sushi.mapper;

import it.project_sushi.model.OrderDetail;
import it.project_sushi.model.Product;
import it.project_sushi.model.dto.OrderDetailDTO;
import it.project_sushi.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring",uses = {ProductMapper.class,OrderMapper.class })
public interface OrderDetailMapper {
	//OrderDetailMapper ISTANCE=Mappers.getMapper(OrderDetailMapper.class);

	@Mapping(target = "product", source = "product", qualifiedByName = "toCartProductDTO")
	default OrderDetailDTO toDto(OrderDetail detail) {
	    OrderDetailDTO dto = new OrderDetailDTO();

	    Product product = detail.getProduct();
	    int quantity = detail.getQuantity();


	    ProductDTO cartProduct = ProductMapper.toCartProductDTO(product, quantity);

	    dto.setQuantity(quantity);
	    dto.setProduct(cartProduct);
	    return dto;
	}


	@Mapping(target = "product", source = "product")
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "orders", ignore = true)
	OrderDetail toEntity(OrderDetailDTO dto);
}
