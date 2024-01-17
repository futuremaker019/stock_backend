package com.stock.analysis.exception;

import com.stock.analysis.dto.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ApplyApplicationException.class)
    public ResponseEntity<?> errorHandler(ApplyApplicationException e) {
        log.error("Error occured {}", e.toString());        // ?? e.toString 은 뭐야
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(Response.error(e.getErrorCode().name()));
    }

}