package com.estagio.supervisionado.oitavo.periodo.back_end.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estagio.supervisionado.oitavo.periodo.back_end.domain.VwTblClinicaDados;

// Camada de acesso ao banco de dados
@Repository
public interface VwTblClinicaDadosRepository extends JpaRepository<VwTblClinicaDados, Integer> {

	// Query que faz a consulta da última informação do banco de dados
	// Alterar o id para ser dinâmico e quando o grupo de bd resolver remover a parte da consulta a partir de do id dinâmico
	@Query(nativeQuery = true, value = "SELECT * FROM vw_tbl_clinica_dados WHERE id= 1 ORDER BY dt_hr_dados DESC limit 1")
	VwTblClinicaDados findLastData();
	
}