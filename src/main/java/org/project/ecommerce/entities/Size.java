package org.project.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sizes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "size_id")
    private String sizeId;

    @Column(name = "size_vale")
    private int sizeValue;
}
