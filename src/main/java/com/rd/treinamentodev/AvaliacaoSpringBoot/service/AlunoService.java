package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.print.attribute.standard.Severity;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    private AlunoService service;



    @GetMapping("/aluno/{cpf}")
    public AlunoDTO buscarPorId(@PathVariable("cpf") Integer cpf) {
        return service.buscarTodas();
    }

    public ResponseEntity gravar(AlunoDTO alunoDTO){
        AlunoEntity entity = new AlunoEntity();
        entity.setNomeAluno(alunoDTO.getNome());
        entity.setCpf(alunoDTO.getCpf());

        //TODO validar se o CPF existe no banco antes de existir, caso exista retornar mensagem de erro


        if () {
            try {
                /*Adicione*/
                Usuario cpfIgual = usuarioNegocio.consultarPorCPF(usuario);
                if(usuario.getCpf().equals(cpfIgual.getCpf())){
                    facesMessages.addFromResourceBundle(Severity.ERROR,
                            "CPF já existente");
                }else{
                    usuarioNegocio.alterar(usuario);
                    facesMessages.addFromResourceBundle(Severity.INFO,
                            "geral.cadastroRealizado");
                }

        entity = alunoRepository.save(entity);

        ResultData resultData = new ResultData(HttpStatus.CREATED.value(), "Aluno cadastrado com sucesso", entity.getIdAluno());
        return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
    }
}
