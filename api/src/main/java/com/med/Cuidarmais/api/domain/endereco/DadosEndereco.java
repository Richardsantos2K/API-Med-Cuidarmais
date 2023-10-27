package com.med.Cuidarmais.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        //complemento é opcional, esta regra de negocio
        String complemento,
        //numero é opcional, esta regra de negocio
        String numero) {
}
