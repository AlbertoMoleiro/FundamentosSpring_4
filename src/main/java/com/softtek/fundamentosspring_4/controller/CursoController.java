package com.softtek.fundamentosspring_4.controller;

import com.softtek.fundamentosspring_4.exceptions.ExceptionNoEncontradoModelo;
import com.softtek.fundamentosspring_4.model.Curso;
import com.softtek.fundamentosspring_4.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("cursos")
public class CursoController {
    @Autowired
    private ICursoService cursoService;

    //@GetMapping
    //public List<Curso> getCursos() {
    //    return this.cursoService.getCursos();
    //}

    @GetMapping
    public ResponseEntity<List<Curso>> getCursos() {
        return new ResponseEntity<>(this.cursoService.getCursos(), HttpStatus.OK);
    }
    //@GetMapping("/{idCurso}")
    //public Curso getCursoById(@PathVariable("idCurso") int idCurso) {
    //    return this.cursoService.getCursoById(idCurso);
    //}

    @GetMapping("/{idCurso}")
    public ResponseEntity<Curso> getCursoById(@PathVariable("idCurso") int idCurso) {
        Curso curso = this.cursoService.getCursoById(idCurso);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }
//    @PostMapping
//    public void createCurso(@RequestBody Curso curso) {
//
//        this.cursoService.createCurso(curso);
//    }

    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        this.cursoService.createCurso(curso);
        return new ResponseEntity<>(curso, HttpStatus.CREATED);
    }


//    @PutMapping
//    public void updateCurso(@RequestBody Curso curso) {
//
//
//        this.cursoService.updateCurso(curso);
//    }

    @PutMapping
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso curso) {
        this.cursoService.updateCurso(curso);
        return new ResponseEntity<>(curso, HttpStatus.CREATED);
    }

//    @DeleteMapping("/{idCurso}")
//    public void deleteCurso(@PathVariable("idCurso") int idCurso) {
//        this.cursoService.deleteCurso(idCurso);
//    }

    @DeleteMapping("/{idCurso}")
    public ResponseEntity<Curso> deleteCurso(@PathVariable("idCurso") int idCurso) throws Exception {
        this.cursoService.deleteCurso(idCurso);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
