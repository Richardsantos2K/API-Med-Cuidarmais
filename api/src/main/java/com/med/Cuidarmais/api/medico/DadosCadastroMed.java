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


        /*
         * Bean validation:
         *
         * Ao inves de fazer um IF e ELSE para essas validações dos campos
         *
         * colocamos as anotações do Bean validation, onde o proprio spring vai fazer essa validação
         * para a gente
         * */



        /*
         * @Pettern:
         *
         *A anotação @Pattern em Java é usada para aplicar validações de padrão a campos de texto.
         * Ela verifica se o conteúdo do campo corresponde a um padrão especificado por uma expressão regular.
         * Se o conteúdo não corresponder ao padrão, uma validação de erro é acionada.
         * Por exemplo, @Pattern(regexp = "\\d{4,6}") validaria se o campo contém entre 4 e 6 dígitos numéricos.
         *
         * regexp:
         *
         * Em resumo, regexp (abreviação de "expressão regular") é uma sequência de caracteres que define um padrão de busca.
         * Em Java, regexp é frequentemente usado em contextos de validação, busca e manipulação de texto para verificar se o texto atende a um padrão específico.
         * Isso é útil para tarefas como validação de entrada de dados, pesquisa de palavras-chave e substituição de texto com base em critérios específicos.
         * Expressões regulares fornecem uma maneira poderosa de descrever e encontrar padrões de texto em strings.
         *
         *
         * //d{} :
         *
         * Em resumo, \\d{} em uma expressão regular é usado para representar dígitos numéricos em um padrão.
         * O \\d representa um dígito, e as chaves {} com um número dentro definem quantas vezes o dígito deve ocorrer.
         * No exemplo \\d{4,6}, isso significa que o padrão aceita de 4 a 6 dígitos numéricos consecutivos.
         * */



}