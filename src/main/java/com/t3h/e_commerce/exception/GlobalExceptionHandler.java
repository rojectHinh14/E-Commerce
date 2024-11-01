package com.t3h.e_commerce.exception;

import com.t3h.e_commerce.dto.ApiHandleResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomExceptionHandler.class)
    public ResponseEntity<ApiHandleResponse<CustomError>> handleProductException(CustomExceptionHandler ex, HttpServletRequest request){

        ApiHandleResponse<CustomError> handleResponse = new ApiHandleResponse<>();
        handleResponse.setStatusCode(ex.getStatus().value());

        CustomError error = ex.getError();
        error.setTimestamp(new Date());
        error.setPath(request.getRequestURI());

        handleResponse.setError(error);

        return ResponseEntity.status(ex.getStatus()).body(handleResponse);

    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiHandleResponse<CustomError>> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException exception,
                                                                           HttpServletRequest request){

        ApiHandleResponse<CustomError> apiHandleResponse = new ApiHandleResponse<>();
        apiHandleResponse.setStatusCode(HttpServletResponse.SC_METHOD_NOT_ALLOWED);

        CustomError customError = new CustomError();
        customError.setCode("METHOD_NOT_ALLOWED");
        customError.setTimestamp(new Date());
        customError.setPath(request.getRequestURI());
        customError.setDetails("The " + exception.getMethod() + " method is not supported for route " + request.getRequestURI()
                                + ". Supported method: " + exception.getSupportedHttpMethods());
        customError.setMessage("The " +exception.getMethod() + " method is not supported for route " + request.getRequestURI()
                + ". Supported method: " + exception.getSupportedHttpMethods());

        apiHandleResponse.setError(customError);

        return new ResponseEntity<>(apiHandleResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomError> handleGeneralException(Exception exception, HttpServletRequest request){

        CustomError response = CustomError.builder()
                .code("INTERNAL_SERVER_ERROR")
                .details("An unexpected error occurred. Please try again later!")
                .message(exception.getMessage())
                .timestamp(new Date())
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiHandleResponse<CustomError>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                                                                                                HttpServletRequest request){
        ApiHandleResponse<CustomError> apiHandleResponse = new ApiHandleResponse<>();
        apiHandleResponse.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);

        apiHandleResponse.setError(CustomError.builder().code("VALIDATION_ERROR")
                .timestamp(new Date())
                .message(Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage())
                .path(request.getRequestURI())
                .details("Please recheck your information!")
                .build());

        return ResponseEntity.badRequest().body(apiHandleResponse);
    }

}
