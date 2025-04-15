package it.project_sushi.mapper;

import it.project_sushi.model.Product;
import it.project_sushi.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	ProductMapper ISTANCE=Mappers.getMapper(ProductMapper.class);
	ProductDTO toDto(Product product);
	@Mapping(target = "active", ignore = true)
	Product toEntity(ProductDTO dto);

	@Named("toDtoForOrder")
	@Mapping(target = "description", ignore = true)
	@Mapping(target = "ingredients", ignore = true)
	ProductDTO toDtoForOrder(Product product);
	
	@Named("toCartProductDTO")
	static ProductDTO toCartProductDTO(Product product, int quantity) {
	    ProductDTO dto = new ProductDTO();
	    dto.setId(product.getId());
	    dto.setName(product.getName());
	    dto.setProductImage(product.getProductImage());
	    dto.setPrice(product.getPrice()); // Calcolo prezzo totale
	    return dto;
	}
	
	@Mapping(target = "active", ignore = true)
	void updateFromDto(ProductDTO dto,@MappingTarget Product product);

}
