package org.project.ecommerce.entities;

import jakarta.persistence.*;
import lombok.*;
import org.project.ecommerce.enums.EnumCurrency;
import org.project.ecommerce.enums.EnumPaymentMethod;
import org.project.ecommerce.enums.EnumPeriod;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "salaries")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "salary_id")
    private String id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "payment_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime paymentDate;

    @Column(name = "bonus")
    private double bonus;

    @Column(name = "deductions")
    private double deductions;

    @Column(name = "payment_method")
    @Enumerated(EnumType.STRING)
    private EnumPaymentMethod paymentMethod;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private EnumCurrency currency;

    @Column(name = "period")
    @Enumerated(EnumType.STRING)
    private EnumPeriod period;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
