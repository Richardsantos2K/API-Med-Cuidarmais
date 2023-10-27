package com.med.Cuidarmais.api.domain.medico.dto;

import com.med.Cuidarmais.api.domain.endereco.Endereco;
import com.med.Cuidarmais.api.domain.medico.Especialidade;
import com.med.Cuidarmais.api.domain.medico.Medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico){
        this(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getTelefone(),
                medico.getEspecialidade(),
                medico.getEndereco());
    }

}
