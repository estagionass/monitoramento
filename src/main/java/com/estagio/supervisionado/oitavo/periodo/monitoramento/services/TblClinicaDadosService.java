package com.estagio.supervisionado.oitavo.periodo.monitoramento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estagio.supervisionado.oitavo.periodo.monitoramento.domain.TblClinicaDados;
import com.estagio.supervisionado.oitavo.periodo.monitoramento.repositories.TblClinicaDadosRepository;

@Service
public class TblClinicaDadosService {

	@Autowired
	private TblClinicaDadosRepository repository;
	
	public TblClinicaDados findLastData() {
		return repository.findLastData();
	}
	
	public List<TblClinicaDados> findLastDataHour() {
		return repository.findLastDataHour();
	}
	
	public TblClinicaDados insert(TblClinicaDados obj) {
		return repository.save(obj);
	}
}
