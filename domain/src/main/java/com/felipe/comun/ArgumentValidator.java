package com.felipe.comun;

import com.felipe.comun.exception.ExceptionInvalidValue;
import com.felipe.comun.exception.ExceptionLengthValue;
import com.felipe.comun.exception.ExceptionRequiredValue;

import java.time.LocalDateTime;
import java.util.Objects;

public class ArgumentValidator {

    private ArgumentValidator(){}

    public static void validateRequired(Object valor, String mensaje) {
        if (valor == null || valor.toString().trim().length() == 0) {
            throw new ExceptionRequiredValue(mensaje);
        }
    }

    public static void validateLength(String valor,int longitud,String mensaje){
        if(!Objects.isNull(valor) && valor.length() < longitud){
            throw new ExceptionLengthValue(mensaje);
        }
    }

    public static void validarMenor(LocalDateTime fechaInicial, LocalDateTime fechaFinal, String mensaje) {
        if (fechaInicial.toLocalDate().isAfter(fechaFinal.toLocalDate())) {
            throw new ExceptionInvalidValue(mensaje);
        }
    }
}
