package com.estagio.supervisionado.oitavo.periodo.back_end.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estagio.supervisionado.oitavo.periodo.back_end.domain.TblClinica;
import com.estagio.supervisionado.oitavo.periodo.back_end.repositories.TblClinicaRepository;

@Service
public class TblClinicaService {

	@Autowired
	private TblClinicaRepository repository;

	public Optional<TblClinica> findClinica(Integer idClinica) {
		Optional<TblClinica> obj = repository.findById(idClinica);
		return  obj;
	}
	
}
