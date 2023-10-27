package com.med.Cuidarmais.api.domain.medico;

import com.med.Cuidarmais.api.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos") // cria uma tabela
@Entity(name = "Medico") // cria uma coluna ou entidade
@Getter //é uma anotação usada em Java para gerar automaticamente métodos de acesso (getters) para campos de uma classe.
@NoArgsConstructor //é uma anotação em Java que gera automaticamente um construtor sem argumentos para uma classe.
@AllArgsConstructor //é uma anotação em Java que gera automaticamente um construtor com argumentos para todos os campos da classe.
@EqualsAndHashCode(of = "id")// para gerar Equals e HashCodes em cima do Id e não em todos os atributos
public class Medico {

    @Id // id da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String nome;
    private String email;
    private String telefone;
    private String crm;



    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    private Boolean ativo;



    @Embedded//@Embeddable é uma anotação que diz que uma classe é usada para partes de outra classe.
    private Endereco endereco;


    public Medico(DadosCadastroMed dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMed dados) {// atualiza informações
        if(dados.nome() != null){ //se o dados nome não tiver null podera atualizar
        this.nome = dados.nome();
        }

        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }

        if (dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void excluir() { // coloca o atributo ativo igual a false
        this.ativo = false;
    }
}
