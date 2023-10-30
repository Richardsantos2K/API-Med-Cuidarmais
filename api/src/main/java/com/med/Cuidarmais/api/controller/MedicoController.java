package com.med.Cuidarmais.api.controller;

import com.med.Cuidarmais.api.domain.medico.*;
import com.med.Cuidarmais.api.domain.medico.dto.DadosDetalhamentoMedico;
import com.med.Cuidarmais.api.domain.medico.dto.DadosAtualizacaoMed;
import com.med.Cuidarmais.api.domain.medico.dto.DadosCadastroMed;
import com.med.Cuidarmais.api.domain.medico.dto.DadosListagemMedico;
import com.med.Cuidarmais.api.domain.medico.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired // feito isso ele ira saber que é ele que ira instanciar e passar este atributo repository dentro da nossa classe controller
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMed dados, UriComponentsBuilder uriBuilder){

        var medico = new Medico(dados);
        repository.save(medico);//id do medico que acabou de ser criado no BD

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri(); //parametro dinamico
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico)); //Código 201
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){//Pageable interface do proprio spring
         var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);

         return ResponseEntity.ok(page); // codigo 200
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMed dados){

        var medico = repository.getReferenceById(dados.id()); // método getReferenceById é usado para buscar pelo Id
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico)); // codigo 200

    }

    /*@DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }*/

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        //deixar como inativo
        //exclusão logica
        var medico = repository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build(); // codigo 204

    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico)); // codigo 204

    } //reaproveitamento de DTO



}
