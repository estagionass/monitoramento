package com.estagio.supervisionado.oitavo.periodo.back_end.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estagio.supervisionado.oitavo.periodo.back_end.domain.TblClinica;

// Camada de acesso ao banco de dados
@Repository
public interface TblClinicaRepository extends JpaRepository<TblClinica, Integer>{
	
}