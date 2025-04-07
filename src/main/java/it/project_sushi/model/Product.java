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
    @Column(name="product_Image")
    private String product_Image;
}
