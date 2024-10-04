package org.project.ecommerce.exceptions;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AppException extends RuntimeException{

    private ErrorCode errorCode;

}
