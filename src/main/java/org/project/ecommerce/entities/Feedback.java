package org.project.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;
import org.project.ecommerce.enums.EnumStatusFeedBack;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "feed_backs")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Feedback extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "feed_back_id")
    private String feedbackId;

    @Column(name = "rating")
    private double rating;

    @Column(name = "comment", columnDefinition = "NVARCHAR(500)")
    private String comment;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumStatusFeedBack status;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
