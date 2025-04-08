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
<<<<<<< HEAD
//	ProductMapper ISTANCE=Mappers.getMapper(ProductMapper.class);
=======
	//ProductMapper ISTANCE=Mappers.getMapper(ProductMapper.class);
>>>>>>> 8d33ba3b311f9e0fc6e6e3208a2f12b0241907d4

	ProductDTO toDto(Product product);

	Product toEntity(ProductDTO dto);

	//@Named("toDtoForOrder")
	//@Mapping(target = "description", ignore = true)
	//@Mapping(target = "ingredients", ignore = true)
	//ProductDTO toDtoForOrder(Product product);
	
<<<<<<< HEAD
//	@Named("toCartProductDTO")
//	static ProductDTO toCartProductDTO(Product product, int quantity) {
//	    ProductDTO dto = new ProductDTO();
//	    dto.setId(product.getId());
//	    dto.setName(product.getName());
//	    dto.setProductImage(product.getProductImage());
//	    dto.setPrice(product.getPrice() * quantity); // Calcolo prezzo totale
//	    return dto;
//	}
=======
	@Named("toCartProductDTO")
	static ProductDTO toCartProductDTO(Product product, int quantity) {
	    ProductDTO dto = new ProductDTO();
	    dto.setId(product.getId());
	    dto.setName(product.getName());
	    dto.setProduct_Image(product.getProduct_Image());
	    dto.setPrice(product.getPrice() * quantity); // Calcolo prezzo totale
	    return dto;
	}
>>>>>>> 8d33ba3b311f9e0fc6e6e3208a2f12b0241907d4
	
	
	void updateFromDto(ProductDTO dto,@MappingTarget Product product);

}
