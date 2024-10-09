package org.project.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.ecommerce.enums.EnumGenner;
import org.project.ecommerce.enums.EnumWorkingStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name", nullable = false, length = 300)
    private String userName;

    @Column(name = "first_name", columnDefinition = "NVARCHAR(300)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "NVARCHAR(300)")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "address", columnDefinition = "NVARCHAR(500)")
    private String address;

    @Column(name = "genner")
    private EnumGenner genner;

    @Column(name = "image")
    private String image;

    @Column(name = "birthDate")
    @DateTimeFormat(pattern = "yyyy-MM-ddd")
    private LocalDateTime birthDate;

    @Column(name = "status")
    private boolean status;

    @Column(name = "lock_number")
    private int lockUser;

    @Column(name = "salary")
    private double salary;

    @Column(name = "working_status")
    private EnumWorkingStatus workingStatus;

    @Column(name = "rating")
    private float rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Salary> salaries;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Feedback> feedbacks;
}
