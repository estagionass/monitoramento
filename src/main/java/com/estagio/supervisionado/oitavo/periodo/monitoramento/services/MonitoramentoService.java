package com.estagio.supervisionado.oitavo.periodo.monitoramento.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estagio.supervisionado.oitavo.periodo.monitoramento.domain.Monitoramento;
import com.estagio.supervisionado.oitavo.periodo.monitoramento.repositories.MonitoramentoRepository;

@Service
public class MonitoramentoService {

	@Autowired
	private MonitoramentoRepository repository;
	
	public Monitoramento findLastObject(){
		List<Monitoramento> list = new ArrayList<>();
		list = repository.findAllByOrderByIdDesc();
		Monitoramento last = list.get(0);
	    return last;
	}
	
	public Monitoramento insert(Monitoramento obj) {
		return repository.save(obj);
	}
}
