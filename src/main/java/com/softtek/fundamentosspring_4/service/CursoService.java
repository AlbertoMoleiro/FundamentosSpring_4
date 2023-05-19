package com.softtek.fundamentosspring_4.service;

import com.softtek.fundamentosspring_4.exceptions.ExceptionNoEncontradoModelo;
import com.softtek.fundamentosspring_4.model.Curso;
import com.softtek.fundamentosspring_4.repository.ICursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService implements ICursoService{
    @Autowired
    private ICursoRepo repo;

    @Override
    public List<Curso> getCursos() {
        return repo.getCursos();
    }

    @Override
    public Curso getCursoById(int idCurso) throws ExceptionNoEncontradoModelo {
        return repo.getCursoById(idCurso);
    }
    @Override
    public void createCurso(Curso curso) {
        this.repo.createCurso(curso);
    }

    @Override
    public void updateCurso(Curso curso) throws ExceptionNoEncontradoModelo {
        this.repo.updateCurso(curso);
    }

    @Override
    public void deleteCurso(int idCurso) throws ExceptionNoEncontradoModelo {
        this.repo.deleteCurso(idCurso);
    }
}
