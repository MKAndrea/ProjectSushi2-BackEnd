package it.project_sushi.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class OrderDTO {
    private Long id;
    private List<OrderDetailDTO> orderDetails;
}
