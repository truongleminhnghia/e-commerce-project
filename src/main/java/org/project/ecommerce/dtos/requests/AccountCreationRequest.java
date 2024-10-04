package org.project.ecommerce.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.project.ecommerce.exceptions.ErrorCode;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class AccountCreationRequest {

    @NotBlank(message = "USERNAME_NOT_BLANK")
    @Size(min = 4, message = "USERNAME_INVALID")
    private String userName;

    @NotBlank(message = "PASSWORD_NOT_BLANK")
    @Size(min = 8, message = "PASSWORD_INVALID")
    private String password;
}
