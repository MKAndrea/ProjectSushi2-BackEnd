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
	public enum Category {
		Cibo,
		Bevande,
		Dolci
	}
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
	@Column(name="productImage")
	private String productImage;
	@Enumerated(EnumType.STRING)
	@Column(name = "category")
	private Category category;
	@Column(name = "active",nullable = false)
	private Boolean active;
	
	@PrePersist
	protected void onCreate() {
	    this.active = true;  // Impostazione di default solo all'inserimento
	}
	
}
