package com.softtek.fundamentosspring_4.controller;

import com.softtek.fundamentosspring_4.exceptions.ExceptionNoEncontradoModelo;
import com.softtek.fundamentosspring_4.model.Curso;
import com.softtek.fundamentosspring_4.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("cursos")
public class CursoController {
    @Autowired
    private ICursoService cursoService;

    //  Nivel 1 Madurez richardson
    //@GetMapping
    //public List<Curso> getCursos() {
    //    return this.cursoService.getCursos();
    //}

    //  Nivel 2 Madurez richardson
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

    //  Nivel 3 Madurez richardson
    @GetMapping("/hateos/{idCurso}")
    public EntityModel<Curso> getCursoByIdHateos(@PathVariable("idCurso") int idCurso) {
        Curso curso = this.cursoService.getCursoById(idCurso);
        if(curso == null) {
            throw new ExceptionNoEncontradoModelo("Curso no encontrado");
        }
        EntityModel<Curso> recurso = EntityModel.of(curso);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getCursos());
        recurso.add(linkTo.withRel("all-cursos"));
        return recurso;
    }


//  Nivel 1 Madurez richardson
//    @PostMapping
//    public void createCurso(@RequestBody Curso curso) {
//
//        this.cursoService.createCurso(curso);
//    }

//  Nivel 2 Madurez richardson

//    @PostMapping
//    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
//        this.cursoService.createCurso(curso);
//        return new ResponseEntity<>(curso, HttpStatus.CREATED);
//    }

    @PostMapping
    public  ResponseEntity<Void> createCurso(@RequestBody Curso curso) throws Exception {
        this.cursoService.createCurso(curso);
        //Como mi servicio no devolvía el curso al crearlo, saco el
        //id del curso de la solicitud. Es solo por no cambiar todos los metodos..
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(curso.getIdCurso()).toUri();
        return ResponseEntity.created(location).build();
    }

    //  Nivel 1 Madurez richardson
//    @PutMapping
//    public void updateCurso(@RequestBody Curso curso) {
//
//
//        this.cursoService.updateCurso(curso);
//    }

//  Nivel 2 Madurez richardson
    @PutMapping
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso curso) {
        this.cursoService.updateCurso(curso);
        return new ResponseEntity<>(curso, HttpStatus.CREATED);
    }

//  Nivel 1 Madurez richardson
//    @DeleteMapping("/{idCurso}")
//    public void deleteCurso(@PathVariable("idCurso") int idCurso) {
//        this.cursoService.deleteCurso(idCurso);
//    }

//  Nivel 2 Madurez richardson
    @DeleteMapping("/{idCurso}")
    public ResponseEntity<Curso> deleteCurso(@PathVariable("idCurso") int idCurso) throws Exception {
        this.cursoService.deleteCurso(idCurso);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
