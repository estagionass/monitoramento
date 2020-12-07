package com.estagio.supervisionado.oitavo.periodo.back_end.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estagio.supervisionado.oitavo.periodo.back_end.domain.TblClinicaDados;
import com.estagio.supervisionado.oitavo.periodo.back_end.repositories.TblClinicaDadosRepository;

@Service
public class TblClinicaDadosService {

	@Autowired
	private TblClinicaDadosRepository repository;
	
	public List<TblClinicaDados> findAverage(Integer id, String dthrini, String dthrfim) {
		return repository.findAverage(id, dthrini, dthrfim);
	}
	
	public TblClinicaDados insert(TblClinicaDados obj) {
		return repository.save(obj);
	}
	
}
