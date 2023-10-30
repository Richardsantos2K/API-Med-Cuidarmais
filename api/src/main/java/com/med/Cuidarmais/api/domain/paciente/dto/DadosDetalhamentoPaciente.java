package com.med.Cuidarmais.api.domain.paciente.dto;

import com.med.Cuidarmais.api.domain.endereco.Endereco;
import com.med.Cuidarmais.api.domain.paciente.Paciente;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {

    public DadosDetalhamentoPaciente(Paciente paciente){
        this(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCpf(),
                paciente.getTelefone(),
                paciente.getEndereco());
    }
}
