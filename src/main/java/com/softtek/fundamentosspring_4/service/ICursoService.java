package com.softtek.fundamentosspring_4.service;

import com.softtek.fundamentosspring_4.exceptions.ExceptionNoEncontradoModelo;
import com.softtek.fundamentosspring_4.model.Curso;
import com.softtek.fundamentosspring_4.repository.ICursoRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ICursoService {
    List<Curso> getCursos();
    Curso getCursoById(int idCurso) throws ExceptionNoEncontradoModelo;
    void createCurso(Curso curso);
    void updateCurso(Curso curso) throws ExceptionNoEncontradoModelo;
    void deleteCurso(int idCurso) throws ExceptionNoEncontradoModelo;
}

