package com.med.Cuidarmais.api.medico;

import com.med.Cuidarmais.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedicos(
        @NotNull
        Long id,

        String nome,
        String telefone,
        DadosEndereco endereco) {
}
