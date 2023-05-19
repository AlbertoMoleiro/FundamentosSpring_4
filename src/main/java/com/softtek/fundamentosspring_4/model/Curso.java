package com.softtek.fundamentosspring_4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Curso {
    private int idCurso;
    private String nombre;
    private int duracion;
    private int idProfesor;
}
