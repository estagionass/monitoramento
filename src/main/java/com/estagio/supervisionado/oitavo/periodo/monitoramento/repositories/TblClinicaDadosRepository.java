package com.estagio.supervisionado.oitavo.periodo.monitoramento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estagio.supervisionado.oitavo.periodo.monitoramento.domain.TblClinicaDados;

@Repository
public interface TblClinicaDadosRepository extends JpaRepository<TblClinicaDados, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM `tbl_clinica_dados` ORDER BY `id` DESC LIMIT 1")
	TblClinicaDados findLastData();
	
	@Query(nativeQuery = true, value = "SELECT * FROM `tbl_clinica_dados` ORDER BY `id` DESC LIMIT 60")
	List<TblClinicaDados> findLastDataHour();
}