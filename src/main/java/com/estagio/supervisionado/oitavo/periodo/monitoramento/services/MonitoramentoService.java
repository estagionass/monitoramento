package com.estagio.supervisionado.oitavo.periodo.monitoramento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estagio.supervisionado.oitavo.periodo.monitoramento.domain.Monitoramento;
import com.estagio.supervisionado.oitavo.periodo.monitoramento.repositories.MonitoramentoRepository;

@Service
public class MonitoramentoService {

	@Autowired
	private MonitoramentoRepository repository;
	
	public Monitoramento findLastData() {
		return repository.findLastData();
	}
	
	public List<Monitoramento> findLastDataHour() {
		return repository.findLastDataHour();
	}
	
	public Monitoramento insert(Monitoramento obj) {
		return repository.save(obj);
	}
}
