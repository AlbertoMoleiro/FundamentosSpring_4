package com.softtek.fundamentosspring_4.repository;

import com.softtek.fundamentosspring_4.exceptions.ExceptionNoEncontradoModelo;
import com.softtek.fundamentosspring_4.model.Curso;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepo implements ICursoRepo {

    private List<Curso> cursos = new ArrayList<Curso>();

    @Override
    public List<Curso> getCursos() {
        return cursos;
    }

    @Override
    public Curso getCursoById(int idCurso) {
        //Buscar en la lista de cursos el curso con el idCurso
        Curso curso = this.cursos.stream()
                .filter(c -> c.getIdCurso() == idCurso)
                .findFirst()
                .orElse(null);
        if(curso == null) {
            throw new ExceptionNoEncontradoModelo("Curso no encontrado");
        }

        return curso;
    }

    @Override
    public void createCurso(Curso curso) {
        this.cursos.add(curso);
    }

    @Override
    public void updateCurso(Curso curso) throws ExceptionNoEncontradoModelo {
        Curso cursoTarget = null;
        for (Curso c : this.cursos) {
            if(c.getIdCurso() == curso.getIdCurso()) {
                cursoTarget = c;
            }
        }
        if(cursoTarget == null) {
            throw new ExceptionNoEncontradoModelo("Curso no encontrado");
        }
        this.cursos.set(this.cursos.indexOf(cursoTarget), curso);
    }

    @Override
    public void deleteCurso(int idCurso) {
        if(!this.cursos.removeIf(c -> c.getIdCurso() == idCurso)){
            throw new ExceptionNoEncontradoModelo("Curso no encontrado");
        };
    }


}
