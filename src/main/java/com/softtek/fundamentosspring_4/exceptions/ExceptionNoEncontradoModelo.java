package com.softtek.fundamentosspring_4.exceptions;

public class ExceptionNoEncontradoModelo extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExceptionNoEncontradoModelo(String mensaje) {
        super(mensaje);
    }
}
