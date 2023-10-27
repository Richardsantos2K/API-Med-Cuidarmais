package com.med.Cuidarmais.api.controller;

import com.med.Cuidarmais.api.domain.paciente.*;
import com.med.Cuidarmais.api.domain.paciente.dto.DadosAtualizacaoPaciente;
import com.med.Cuidarmais.api.domain.paciente.dto.DadosCadastroPaciente;
import com.med.Cuidarmais.api.domain.paciente.dto.DadosListagemPaciente;
import com.med.Cuidarmais.api.domain.paciente.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados){

        var paciente = repository.getReferenceById(dados.id()); // método getReferenceById é usado para buscar pelo Id
        paciente.atualizarInformacoes(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        //deixar como inativo
        //exclusão logica
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }


}
