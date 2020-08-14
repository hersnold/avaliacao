package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;

import com.rd.treinamentodev.AvaliacaoSpringBoot.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CursoController {
    @Autowired
    private CursoService cursoService;
    @Autowired
    private CursoRepository repository;

    @GetMapping("/cursos/{nomeCurso}")
    public ResponseEntity buscarPorNome(@PathVariable("nomeCurso") String nomeCurso){
        return ResponseEntity.ok().body(cursoService.buscarPorNome(nomeCurso));
    }
    @PostMapping("/cursos")
    public ResponseEntity gravar(@RequestBody CursoDTO cursoDTO) throws Exception {
        return cursoService.adicionar(cursoDTO);
    }
    @GetMapping("/cursos")
    public ResponseEntity<Object> listarTodos() {
        return ResponseEntity.ok().body(repository.findAll());
    }

}
