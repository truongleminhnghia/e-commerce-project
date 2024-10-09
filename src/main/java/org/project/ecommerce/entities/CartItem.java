package org.project.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cart_items")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class CartItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cart_item_id")
    private String cartItemId;

    private double price;

    private int quantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false, unique = true)
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
}
