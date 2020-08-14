package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.AlunoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.BO.AlunoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Severity;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;


    public ResponseEntity gravar(AlunoDTO alunoDTO){
        ResultData resultData = null;
        if(alunoRepository.findByCpf(alunoDTO.getCpf()).size() > 0){
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(), "CPF Existente");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultData);
        }else {

            AlunoEntity entity = new AlunoEntity();
            entity.setCpf(alunoDTO.getCpf());
            entity.setNomeAluno(alunoDTO.getNome());

            entity = alunoRepository.save(entity);

            return ResponseEntity.status(HttpStatus.CREATED).body("Tudo certo por aqui, cadastrado com sucesso");
        }


    }
}
