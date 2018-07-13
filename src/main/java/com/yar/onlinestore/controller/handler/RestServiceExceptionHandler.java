package com.yar.onlinestore.controller.handler;


import com.stts.onlinestore.common.exception.*;
import com.yar.onlinestore.common.exception.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class RestServiceExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> defaultExceptionHandler(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiError apiError = new ApiError(
                status, ex.getLocalizedMessage(), "Exception:: " + ex.getMessage());
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }


    @ExceptionHandler(value = DAOException.class)
    public ResponseEntity<?> daoExceptionHandler( DAOException ex) {
        HttpStatus status = HttpStatus.CONFLICT;
        ApiError apiError = new ApiError(
                status, ex.getLocalizedMessage(), "DAO Exception::" + ex.getMessage());
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }


    @ExceptionHandler(value = InternalException.class)
    public ResponseEntity<?> internalExceptionHandler( InternalException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiError apiError = new ApiError(
                status, ex.getLocalizedMessage(), "Internal Exception:: " + ex.getMessage());
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }


    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<?> requestExceptionHandler( RequestException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ApiError apiError = new ApiError(
                status, ex.getLocalizedMessage(), "Request Exception:: " + ex.getMessage());
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }


    @ExceptionHandler(value = ResponseException.class)
    public ResponseEntity<?> responseExceptionHandler( ResponseException ex) {
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        ApiError apiError = new ApiError(
                status, ex.getLocalizedMessage(), "Response Exception:: " + ex.getMessage());
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }


    @ExceptionHandler(value = ServiceException.class)
    public ResponseEntity<?> serviceExceptionHandler( ServiceException ex) {
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        ApiError apiError = new ApiError(
                status, ex.getLocalizedMessage(), "Service Exception:: " + ex.getMessage());
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }


    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }


}
