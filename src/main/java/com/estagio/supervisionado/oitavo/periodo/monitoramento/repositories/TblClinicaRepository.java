package com.estagio.supervisionado.oitavo.periodo.monitoramento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estagio.supervisionado.oitavo.periodo.monitoramento.domain.TblClinica;

@Repository
public interface TblClinicaRepository extends JpaRepository<TblClinica, Integer>{
	
}