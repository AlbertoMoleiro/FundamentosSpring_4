package com.softtek.fundamentosspring_4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
@RestController
public class InterceptorErrors extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionRespuesta> manejarTodas(Exception ex, WebRequest request){
        ExceptionRespuesta exception = new ExceptionRespuesta(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ExceptionNoEncontradoModelo.class)
    public ResponseEntity<ExceptionRespuesta> manejarModeloNoEncontrado(ExceptionNoEncontradoModelo ex, WebRequest request){
        ExceptionRespuesta exception = new ExceptionRespuesta(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

}
