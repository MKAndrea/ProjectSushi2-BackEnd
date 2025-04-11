package it.project_sushi.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Data
@Table(name="order_detail")
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "id_orders")
    private Order orders;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

}
