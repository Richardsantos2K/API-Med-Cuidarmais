package com.med.Cuidarmais.api.domain.medico.dto;

import com.med.Cuidarmais.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMed(
        @NotNull
        Long id,

        String nome,
        String telefone,
        DadosEndereco endereco) {
}
