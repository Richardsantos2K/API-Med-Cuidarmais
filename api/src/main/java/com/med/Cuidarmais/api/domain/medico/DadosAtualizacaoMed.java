package com.med.Cuidarmais.api.domain.medico;

import com.med.Cuidarmais.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMed(
        @NotNull
        Long id,

        String nome,
        String telefone,
        DadosEndereco endereco) {
}
