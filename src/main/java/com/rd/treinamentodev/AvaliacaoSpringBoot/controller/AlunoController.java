package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.AlunoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {

    @Autowired
    private AlunoService alunoService;
    @Autowired
    private AlunoRepository repository;
    @GetMapping("/aluno")
    public ResponseEntity<Object> listarTodos(){
        return ResponseEntity.ok().body(repository.findAll());
    }
    @PostMapping("/aluno")
    public ResponseEntity gravar(@RequestBody AlunoDTO alunoDTO){
        return alunoService.gravar(alunoDTO);
    }
}
