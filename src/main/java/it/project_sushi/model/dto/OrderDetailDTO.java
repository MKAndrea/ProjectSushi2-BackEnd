package it.project_sushi.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class OrderDetailDTO {
    private int quantity;
    private ProductDTO product;
}