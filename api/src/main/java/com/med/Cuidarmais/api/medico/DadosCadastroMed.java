package com.med.Cuidarmais.api.medico;

import com.med.Cuidarmais.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMed(
        @NotBlank// verifica se este campo esta vazio, e diz que o mesmo n pode ser nulo, ou seja, n pode ter o valor null
        String nome,

        @NotBlank
        @Email // como é um email é obrigatorio ter @ e o dominio deste email por isso a anotação @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")/*por padrão o crm tem que ter de 4 a 6 numeros para ser valido, por isso passamos
        uma "expressão regular" com o @Pattern e dentro dos parentes colocamos (regexp = "\\d{4,6}")
        para dizer que podera ter apenas de 4 a 6 digitos */
        String crm,

        @NotNull
        @Valid/*@Valid é usado para garantir que as anotações de validação do Bean Validation sejam aplicadas a um DTO, incluindo seus atributos, quando o DTO é utilizado dentro de outro DTO.*/
        Especialidade especialidade,

        @Valid
        DadosEndereco endereco) {

}