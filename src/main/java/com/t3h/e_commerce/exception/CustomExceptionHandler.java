package com.t3h.e_commerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomExceptionHandler extends RuntimeException{

    HttpStatus status;
    CustomError error;

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setError(CustomError error) {
        this.error = error;
    }

    public static CustomExceptionHandler notFoundException(String message){
        CustomExceptionHandler notFound = new CustomExceptionHandler();
        notFound.setError(new CustomError("NOT_FOUND", message,
                "The information that you provided for us could not be found. Please recheck your information!"));
        notFound.setStatus(HttpStatus.NOT_FOUND);
        return notFound;

    }

    public static CustomExceptionHandler badRequestException(String message) {
        CustomExceptionHandler badRequest = new CustomExceptionHandler();
        badRequest.setError(new CustomError("BAD_REQUEST", message,
                "The information that you provided for us could be bad requested. Please recheck your information!"));
        badRequest.setStatus(HttpStatus.BAD_REQUEST);
        return badRequest;
    }

    public static CustomExceptionHandler unauthorizedException(String message) {
        CustomExceptionHandler unauthorized = new CustomExceptionHandler();
        unauthorized.setError(new CustomError("UNAUTHORIZED", message, null));
        unauthorized.setStatus(HttpStatus.UNAUTHORIZED);
        return unauthorized;
    }




}
