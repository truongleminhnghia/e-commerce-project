package org.project.ecommerce.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserUpdateResphone {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String gener;
    private LocalDate birthDate;
}
