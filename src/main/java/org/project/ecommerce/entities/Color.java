package org.project.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "colors")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Color extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "color_id")
    private String colorId;

    @Column(name = "color_name", nullable = false, columnDefinition = "NVARCHAR(100)")
    private String colorName;
}
