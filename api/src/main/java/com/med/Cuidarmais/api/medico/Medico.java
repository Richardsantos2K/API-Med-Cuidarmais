package com.med.Cuidarmais.api.medico;

import com.med.Cuidarmais.api.endereco.Endereco;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*A anotação @GeneratedValue(strategy = GenerationType.IDENTITY)
                                                          especifica a geração automática de valores de chave primária com base em identidade,
                                                          geralmente para colunas autoincrementáveis em bancos de dados.*/
    private Long id;



    private String nome;
    private String email;
    private String telefone;
    private String crm;



    @Enumerated(EnumType.STRING)/*A anotação @Enumerated(EnumType.STRING) é usada para mapear uma enumeração (enum) em um banco de dados
                                  de forma que os valores sejam armazenados como strings, em vez de inteiros, tornando os dados mais legíveis.
                                 */
    private Especialidade especialidade;



    @Embedded//@Embeddable é uma anotação que diz que uma classe é usada para partes de outra classe.
    private Endereco endereco;


    public Medico(DadosCadastroMed dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());/*Nesse construtor, o atributo "endereco" está instanciado porque ele
         está sendo inicializado com um novo objeto Endereco baseado nos dados fornecidos no parâmetro dados.endereco().
          Isso significa que sempre que você criar uma instância de Medico usando esse construtor,
          um novo objeto Endereco será criado com base nas informações do endereço fornecidas em dados.endereco()
           e atribuído ao atributo endereco da instância de Medico.
           Isso pode ser útil para garantir que cada médico tenha uma instância única de Endereco.*/
    }

    public void atualizarInformacoes(DadosAtualizacaoMedicos dados) {
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
}
