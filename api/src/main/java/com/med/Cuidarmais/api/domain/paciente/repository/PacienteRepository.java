package com.med.Cuidarmais.api.domain.paciente.repository;

import com.med.Cuidarmais.api.domain.paciente.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository <Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable paginacao);
}
