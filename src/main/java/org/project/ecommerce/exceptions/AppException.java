package org.project.ecommerce.exceptions;

import lombok.*;
import org.project.ecommerce.enums.ErrorCode;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AppException extends RuntimeException{

    private ErrorCode errorCode;

}
