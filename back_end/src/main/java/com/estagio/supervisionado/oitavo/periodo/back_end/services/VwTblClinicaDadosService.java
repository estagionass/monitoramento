package com.estagio.supervisionado.oitavo.periodo.back_end.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estagio.supervisionado.oitavo.periodo.back_end.domain.VwTblClinicaDados;
import com.estagio.supervisionado.oitavo.periodo.back_end.repositories.VwTblClinicaDadosRepository;

@Service
public class VwTblClinicaDadosService {

	@Autowired
	private VwTblClinicaDadosRepository repository;
	
	public VwTblClinicaDados findLastData(Integer id) {
		return repository.findLastData(id);
	}
	
}
