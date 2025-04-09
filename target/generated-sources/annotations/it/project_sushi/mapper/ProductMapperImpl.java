package it.project_sushi.mapper;

import it.project_sushi.model.Product;
import it.project_sushi.model.dto.ProductDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-08T15:26:16+0200",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.41.0.v20250213-1140, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toDto(Product product) {
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

    @Override
    public Product toEntity(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

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

        product.setDescription( dto.getDescription() );
        product.setId( dto.getId() );
        product.setIngredients( dto.getIngredients() );
        product.setName( dto.getName() );
        product.setPrice( dto.getPrice() );
        product.setProductImage( dto.getProductImage() );
    }
}
