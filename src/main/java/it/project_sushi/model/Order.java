package it.project_sushi.model;


import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Data
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="active",nullable = false)
    private boolean active = true;
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderDetail> orderDetails;
    
    @PrePersist
    protected void onCreate() {
        this.active = true;
    }
}
