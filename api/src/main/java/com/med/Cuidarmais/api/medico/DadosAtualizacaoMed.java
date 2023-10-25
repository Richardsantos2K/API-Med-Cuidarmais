package com.med.Cuidarmais.api.medico;

import com.med.Cuidarmais.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMed(
        @NotNull
        Long id,

        String nome,
        String telefone,
        DadosEndereco endereco) {
}
