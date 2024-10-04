package org.project.ecommerce.entities;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class BaseEntity {

    @Column(name = "create_at")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm::ss")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm::ss")
    private LocalDateTime updateAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updateAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateAt = LocalDateTime.now();
    }
}
