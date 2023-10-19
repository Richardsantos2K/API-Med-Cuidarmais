package com.med.Cuidarmais.api.medico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> { // passaremos os generics, passaremos dois objetos
    //O tipo de entidade que este Repository ira trabalhar é Medico
    //O tipo de atributo da chave primaria desta entidade que é Long, então passamos Long como parametro

    /*
    * Isto é uma interface que esta herdando de JpaRepository
    * Então todos os métodos que temos nesta interface e nas outras que esta interface esta herdando
    * a gente ganha automaticamente todos os metodos e atributos
    *
    * Tudo isto o Spring faz automaticamente para gente
    *
    * agora podemos usar este repository la no nosso controller
    * */
}
