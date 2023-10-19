package com.med.Cuidarmais.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable//@Embeddable é uma anotação que diz que uma classe é usada para partes de outra classe.
@Getter //é uma anotação usada em Java para gerar automaticamente métodos de acesso (getters) para campos de uma classe.
@NoArgsConstructor //é uma anotação em Java que gera automaticamente um construtor sem argumentos para uma classe.
@AllArgsConstructor //é uma anotação em Java que gera automaticamente um construtor com argumentos para todos os campos da classe.
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }
}
