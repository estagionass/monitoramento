package com.estagio.supervisionado.oitavo.periodo.monitoramento.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estagio.supervisionado.oitavo.periodo.monitoramento.domain.TblClinicaDados;
import com.estagio.supervisionado.oitavo.periodo.monitoramento.services.TblClinicaDadosService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/v1/monitoramento")
public class TblClinicaDadosResource {
	
	@Autowired
	private TblClinicaDadosService service;
	
	@GetMapping
	public ResponseEntity<?> findLastData(){
		TblClinicaDados obj = service.findLastData();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/media")
	@GetMapping
	public ResponseEntity<?> findLastDataHour(){
		List<TblClinicaDados> objs = new ArrayList<>();
		Double mediaTemperatura = 0.0;
		objs = service.findLastDataHour();
		for (int i = 0; i < objs.size(); i++) {
			mediaTemperatura += objs.get(i).getTemperatura();
		}
		mediaTemperatura = mediaTemperatura / 60;
		return ResponseEntity.ok().body(mediaTemperatura);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody TblClinicaDados obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().build();
	}
	
}
