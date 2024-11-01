package com.t3h.e_commerce.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomError {
    private String code;
    private String message;
    private String details;
    private Date timestamp;
    private String path;

    public CustomError(String code, String message, String details, Date timestamp, String path) {
        this.code = code;
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
        this.path = path;
    }

    public CustomError(String code, String message, String details) {
        this.code = code;
        this.message = message;
        this.details = details;
    }

    public CustomError() {
    }

}
