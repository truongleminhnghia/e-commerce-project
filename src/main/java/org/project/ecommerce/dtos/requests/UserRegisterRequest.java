package org.project.ecommerce.dtos.requests;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserRegisterRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private String gener;
    private String password;
    private String confirmPassword;
    private LocalDate birthDate;
}
