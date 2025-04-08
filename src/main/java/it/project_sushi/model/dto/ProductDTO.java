package it.project_sushi.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonProperty;
=======
>>>>>>> 8d33ba3b311f9e0fc6e6e3208a2f12b0241907d4
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
<<<<<<< HEAD
//@JsonInclude(JsonInclude.Include.NON_NULL)
=======
@JsonInclude(JsonInclude.Include.NON_NULL)
>>>>>>> 8d33ba3b311f9e0fc6e6e3208a2f12b0241907d4
public class ProductDTO {
    private Long id;
    private String name;
    private String ingredients;
    private String description;
    private double price;
<<<<<<< HEAD
    private String productImage;
=======
    private String product_Image;
>>>>>>> 8d33ba3b311f9e0fc6e6e3208a2f12b0241907d4
}
