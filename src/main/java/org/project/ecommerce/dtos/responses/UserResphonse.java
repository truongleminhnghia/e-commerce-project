package org.project.ecommerce.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.ecommerce.entities.Role;
import org.project.ecommerce.enums.EnumGenner;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserResphonse {
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String password;
    private String image;
    private EnumGenner genner;
    private LocalDate birthDate;
    private Role role;
    private boolean status;
}
