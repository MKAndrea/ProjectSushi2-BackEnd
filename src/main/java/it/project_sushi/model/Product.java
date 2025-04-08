package it.project_sushi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@Table(name="product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="ingredients")
    private String ingredients;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private double price;
<<<<<<< HEAD
    @Column(name="productImage")
    private String productImage;
=======
    @Column(name="product_Image")
    private String product_Image;
>>>>>>> 8d33ba3b311f9e0fc6e6e3208a2f12b0241907d4
}
