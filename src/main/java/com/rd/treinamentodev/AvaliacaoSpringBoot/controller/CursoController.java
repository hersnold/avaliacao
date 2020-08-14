package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.BO.CursoBO;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {

    public void inserir(CursoDTO dto, CursoBO bo,CursoRepository repository) {
        CursoEntity entity = bo.parseToEntity(dto, null);
        if(entity.getNomeCurso() != null)
            repository.save(entity);
    }
}
