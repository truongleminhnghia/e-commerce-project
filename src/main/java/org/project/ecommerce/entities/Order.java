package org.project.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.ecommerce.enums.EnumStatusOrder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "orrder_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime orderDate;

    @Column(name = "name_shipping", columnDefinition = "NVARCHAR(300)")
    private String nameShipping;

    @Column(name = "email_shipping")
    private String emailShipping;

    @Column(name = "address_shipping", columnDefinition = "NVARCHAR(300)")
    private String addressShipping;

    @Column(name = "phone_shipping", length = 15)
    private String phoneShipping;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EnumStatusOrder status;

    @Column(name = "note", columnDefinition = "NVARCHAR(500)")
    private String note;

    @Column(name = "reason", columnDefinition = "NVARCHAR(100)")
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", nullable = false)
    private User staff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id", nullable = false)
    private User delivery;
}
