package com.rd.treinamentodev.AvaliacaoSpringBoot.service.BO;


import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import org.springframework.stereotype.Component;

@Component
public class CursoBO {

    public CursoDTO parseToDTO(CursoEntity entity){
        CursoDTO dto = new CursoDTO();

        if(entity == null)
            return dto;


        dto.setNome(entity.getNomeCurso());
        dto.setCargaHoraria(entity.getNrCargaHoraria());


        return dto;
    }


    public static CursoEntity parseToEntity(CursoDTO dto, CursoEntity entity){
        if(entity == null)
            entity = new CursoEntity();

        if(dto == null)
            return entity;

        entity.setNomeCurso(dto.getNome());
        entity.setNrCargaHoraria(dto.getCargaHoraria());


        return entity;
    }

}