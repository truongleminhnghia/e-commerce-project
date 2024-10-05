package org.project.ecommerce.dtos.responses;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter

public class AuthenticationResponse {

    private boolean authenticated;
}
