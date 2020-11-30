package com.estagio.supervisionado.oitavo.periodo.back_end.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estagio.supervisionado.oitavo.periodo.back_end.domain.TblClinicaDados;

// Camada de acesso ao banco de dados
@Repository
public interface TblClinicaDadosRepository extends JpaRepository<TblClinicaDados, Integer>{
	
	// Query que faz a consulta da última informação do banco de dados
	@Query(nativeQuery = true, value = "SELECT * FROM `tbl_clinica_dados` ORDER BY `id` DESC LIMIT 1")
	TblClinicaDados findLastData();
	
	// Query que faz a consulta dos 60 últimos dados do banco de dados, para fazer a média da temperatura
	@Query(nativeQuery = true, value = "SELECT * FROM `tbl_clinica_dados` ORDER BY `id` DESC LIMIT 60")
	List<TblClinicaDados> findLastDataHour();
}