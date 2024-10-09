package org.project.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "category_name", nullable = false, columnDefinition = "NVARCHAR(200)")
    private String categoryName;

    @Column(name = "status", nullable = false)
    private boolean status;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}
