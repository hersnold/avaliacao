package com.rd.treinamentodev.AvaliacaoSpringBoot.service.BO;


import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import org.springframework.stereotype.Component;

@Component
public class AlunoBO {

    public AlunoDTO parseDTO(AlunoEntity entity){
        AlunoDTO dto = new AlunoDTO();

        dto.setCpf(entity.getCpf());
        dto.setNome(entity.getNomeAluno());

        return dto;
    }
}


