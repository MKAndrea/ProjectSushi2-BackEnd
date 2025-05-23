package it.project_sushi.mapper;

import it.project_sushi.model.Product;
import it.project_sushi.model.dto.ProductDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-23T17:07:33+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.36.0.v20231114-0937, environment: Java 17.0.9 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setCategory( product.getCategory() );
        productDTO.setDescription( product.getDescription() );
        productDTO.setId( product.getId() );
        productDTO.setIngredients( product.getIngredients() );
        productDTO.setName( product.getName() );
        productDTO.setPrice( product.getPrice() );
        productDTO.setProductImage( product.getProductImage() );

        return productDTO;
    }

    @Override
    public Product toEntity(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setCategory( dto.getCategory() );
        product.setDescription( dto.getDescription() );
        product.setId( dto.getId() );
        product.setIngredients( dto.getIngredients() );
        product.setName( dto.getName() );
        product.setPrice( dto.getPrice() );
        product.setProductImage( dto.getProductImage() );

        return product;
    }

    @Override
    public ProductDTO toDtoForOrder(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setCategory( product.getCategory() );
        productDTO.setId( product.getId() );
        productDTO.setName( product.getName() );
        productDTO.setPrice( product.getPrice() );
        productDTO.setProductImage( product.getProductImage() );

        return productDTO;
    }

    @Override
    public void updateFromDto(ProductDTO dto, Product product) {
        if ( dto == null ) {
            return;
        }

        product.setCategory( dto.getCategory() );
        product.setDescription( dto.getDescription() );
        product.setId( dto.getId() );
        product.setIngredients( dto.getIngredients() );
        product.setName( dto.getName() );
        product.setPrice( dto.getPrice() );
        product.setProductImage( dto.getProductImage() );
    }
}
