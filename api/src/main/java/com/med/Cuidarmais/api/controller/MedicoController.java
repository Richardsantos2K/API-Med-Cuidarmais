package com.med.Cuidarmais.api.controller;

import com.med.Cuidarmais.api.medico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired // feito isso ele ira saber que é ele que ira instanciar e passar este atributo repository dentro da nossa classe controller
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMed dados){

        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){//Pageable interface do proprio spring
        return repository.findAll(paginacao).map(DadosListagemMedico::new);

    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dados){

        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

    }


}
