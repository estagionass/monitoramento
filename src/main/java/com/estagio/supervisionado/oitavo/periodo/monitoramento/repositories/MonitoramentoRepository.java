package com.estagio.supervisionado.oitavo.periodo.monitoramento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estagio.supervisionado.oitavo.periodo.monitoramento.domain.Monitoramento;

@Repository
public interface MonitoramentoRepository extends JpaRepository<Monitoramento, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM `tbl_clinica_dados` ORDER BY `id` DESC LIMIT 1")
	Monitoramento findLastData();
	
	@Query(nativeQuery = true, value = "SELECT * FROM `tbl_clinica_dados` ORDER BY `id` DESC LIMIT 60")
	List<Monitoramento> findLastDataHour();
}