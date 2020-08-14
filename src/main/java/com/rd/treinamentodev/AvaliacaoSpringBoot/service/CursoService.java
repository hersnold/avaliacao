package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class CursoService {


    @Autowired
    private CursoRepository repository;
    @Autowired
    private CursoEntity entity;

    public ResponseEntity adicionar(CursoDTO cursoDTO) throws Exception {
        if(entity.getNomeCurso() != null) {
            CursoEntity entity = new CursoEntity();
            entity.setNomeCurso(cursoDTO.getNome());
            entity.setNrCargaHoraria(cursoDTO.getCargaHoraria());
            entity = repository.save(entity);
        }

        ResultData resultado = new ResultData(HttpStatus.CREATED.value(), "Curso adicionado", entity.getIdCurso());
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }


    public List<CursoEntity> buscarPorNome(String nomeCurso){
        return repository.findByNomeCurso(nomeCurso);
    }

}