package com.med.Cuidarmais.api.medico;

import com.med.Cuidarmais.api.endereco.DadosEndereco;

public record DadosCadastroMed(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
}