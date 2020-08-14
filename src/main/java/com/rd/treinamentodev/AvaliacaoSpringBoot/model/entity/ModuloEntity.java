package com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity;

import lombok.Data;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;

@Entity
@Table(name = "tb_modulo")
@Data
public class ModuloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modulo")
//    @JsonIgnore
    private Long idModulo;

    @Column(name = "ds_nome")
    private String nomeModulo;

    @OneToOne
    @JoinColumn(name = "id_instrutor")
    private InstrutorEntity idInstrutor;
}
