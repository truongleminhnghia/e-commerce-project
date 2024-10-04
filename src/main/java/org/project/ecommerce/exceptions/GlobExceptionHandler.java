package org.project.ecommerce.exceptions;

import org.project.ecommerce.dtos.responses.ApiResponse;
import org.project.ecommerce.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobExceptionHandler {

    @ExceptionHandler(value = Exception.class)  // o bat cu dau co loi RuntimeException thi se duoc bat loi o day
    ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException exception) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)  // o bat cu dau co loi RuntimeException thi se duoc bat loi o day
    ResponseEntity<ApiResponse> handlingRuntimeException(AppException exception) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(ErrorCode.USER_EXISTED.getCode());
        apiResponse.setMessage(ErrorCode.USER_EXISTED.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        String enumKey = exception.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.INVALID_KEY;
        try {
            errorCode = ErrorCode.valueOf(enumKey);
        } catch (IllegalArgumentException e) {

        }

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

}
