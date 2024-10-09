package org.project.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.ecommerce.enums.EnumCurrency;
import org.project.ecommerce.enums.EnumPayMentStatus;
import org.project.ecommerce.enums.EnumPaymentMethod;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "payments")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "payemt_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate paymentDate;

    @Column(name = "amount")
    private double amount;

    @Column(name = "payment_method", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumPaymentMethod paymentMethod;

    @Column(name = "currency", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumCurrency currency;

    @Column(name = "payment_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumPayMentStatus payMentStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private Order order;
}
