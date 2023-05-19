package com.softtek.fundamentosspring_4.repository;

import com.softtek.fundamentosspring_4.exceptions.ExceptionNoEncontradoModelo;
import com.softtek.fundamentosspring_4.model.Curso;

import java.util.List;

public interface ICursoRepo {
    List<Curso> getCursos();
    Curso getCursoById(int idCurso)throws ExceptionNoEncontradoModelo;
    void createCurso(Curso curso);
    void updateCurso(Curso curso) throws ExceptionNoEncontradoModelo;
    void deleteCurso(int idCurso) throws ExceptionNoEncontradoModelo;
}
