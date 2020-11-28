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

import com.estagio.supervisionado.oitavo.periodo.monitoramento.domain.Monitoramento;
import com.estagio.supervisionado.oitavo.periodo.monitoramento.services.MonitoramentoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value="/api/v1/monitoramento")
public class MonitoramentoResource {
	
	@Autowired
	private MonitoramentoService service;
	
	@GetMapping
	public ResponseEntity<?> findLastData(){
		Monitoramento obj = service.findLastData();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/media")
	@GetMapping
	public ResponseEntity<?> findLastDataHour(){
		List<Monitoramento> objs = new ArrayList<>();
		Double mediaTemperatura = 0.0;
		objs = service.findLastDataHour();
		for (int i = 0; i < objs.size(); i++) {
			mediaTemperatura += objs.get(i).getTemperatura();
		}
		mediaTemperatura = mediaTemperatura / 60;
		return ResponseEntity.ok().body(mediaTemperatura);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Monitoramento obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().build();
	}
	
}
