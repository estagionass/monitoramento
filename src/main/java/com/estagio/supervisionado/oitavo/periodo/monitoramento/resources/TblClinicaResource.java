package com.estagio.supervisionado.oitavo.periodo.monitoramento.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import com.estagio.supervisionado.oitavo.periodo.monitoramento.domain.TblClinica;
import com.estagio.supervisionado.oitavo.periodo.monitoramento.services.TblClinicaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1/monitoramento/clinica/{idClinica}")
public class TblClinicaResource {

	@Autowired
	private TblClinicaService service;

	@GetMapping
	public ResponseEntity<?> findClinica(@PathVariable Integer idClinica) {
		Optional<TblClinica> obj = service.findClinica(idClinica);
		return ResponseEntity.ok().body(obj);
	}
	
}
