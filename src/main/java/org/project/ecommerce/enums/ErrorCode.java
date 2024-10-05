package org.project.ecommerce.enums;

import lombok.*;


@Getter
@NoArgsConstructor

public enum ErrorCode {
    INVALID_KEY(10001, "Invalid message key"),
    USER_EXISTED(1002, "Account existed"),
    UNCATEGORIZED_EXCEPTION(1003, "Uncategorized error"),
    USERNAME_INVALID(1004, "Username must be at least 4 characters"),
    USERNAME_NOT_BLANK(1005, "Username cannot be blank"),
    PASSWORD_INVALID(1006, "Password must be at least 3 characters"),
    PASSWORD_NOT_BLANK(1007, "Password cannot be blank"),
    HELLO_WORLD(1008, "Hello world"),
    USER_NOT_EXISTED(1009, "User not existed"),
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
