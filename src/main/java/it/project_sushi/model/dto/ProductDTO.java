package it.project_sushi.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import it.project_sushi.model.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
    private Long id;
    private String name;
    private String ingredients;
    private String description;
    private double price;
    private String productImage;
    private Product.Category category;
}
