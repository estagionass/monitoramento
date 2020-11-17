package com.estagio.supervisionado.oitavo.periodo.monitoramento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estagio.supervisionado.oitavo.periodo.monitoramento.domain.Monitoramento;

@Repository
public interface MonitoramentoRepository extends JpaRepository<Monitoramento, Integer>{
	
	//Método reponsável por retornar uma lista de todos os objetos ordenados pelo id e ordenados de forma decrescente
	public List<Monitoramento> findAllByOrderByIdDesc();
}