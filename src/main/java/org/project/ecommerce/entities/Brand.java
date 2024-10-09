package org.project.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "brands")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Brand extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "brand_id")
    private String brandId;

    @Column(name = "brand_name", nullable = false, columnDefinition = "NVARCHAR(300)")
    private String brandName;

    @Column(name = "status", nullable = false)
    private boolean status;

    @OneToMany(mappedBy = "brand")
    private Set<Product> products;
}
