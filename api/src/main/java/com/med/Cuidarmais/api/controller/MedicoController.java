package com.med.Cuidarmais.api.controller;

import com.med.Cuidarmais.api.medico.DadosCadastroMed;
import com.med.Cuidarmais.api.medico.Medico;
import com.med.Cuidarmais.api.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    /*pegaremos o repositoty e mandaremos percistir no banco de dados.

      precisamos da classe da interface repository.

      e por isso declaramos como sendo um atributo da classe controller.

      Com isso faremos com que ao insves de nos instanciarmos esta classe
      o proprio spring ira instanciar para gente.

      Isso se chama INJEÇÃO DE DEPENDÊNCIAS
     */
    @Autowired // feito isso ele ira saber que é ele que ira instanciar e passar este atributo repository dentro da nossa classe controller
    private MedicoRepository repository;

    @PostMapping
    @Transactional/*@Transactional é uma anotação em Java usada para marcar métodos ou classes,
                    indicando que as operações dentro delas são transacionais, ou seja, elas serão executadas como uma única unidade de trabalho
                     que é confirmada (commit) ou revertida (rollback) automaticamente se ocorrer algum erro.
                     Isso é comumente usado em acesso a bancos de dados para garantir a consistência dos dados.*/
    public void cadastrar(@RequestBody @Valid DadosCadastroMed dados){

        repository.save(new Medico(dados));
    } /*
    Essa linha está salvando uma nova instância de Medico no repositório (em um banco de dados)
     usando o método save do objeto repository. ou seja, sempre que tiver um novo medico passara aqui para salvar.
     A instância de Medico é criada com base nos dados fornecidos no parâmetro dados
      e passada diretamente para o repositório para ser persistida.
      Isso é uma operação comum ao usar frameworks de persistência de dados, como o Spring Data JPA,
      para armazenar informações em um banco de dados.
    */
}
