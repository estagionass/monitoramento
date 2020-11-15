package com.estagio.supervisionado.oitavo.periodo.monitoramento.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estagio.supervisionado.oitavo.periodo.monitoramento.domain.Monitoramento;
import com.estagio.supervisionado.oitavo.periodo.monitoramento.services.MonitoramentoService;

@RestController
@RequestMapping(value="/api/v1/monitoramento")
public class MonitoramentoResource {
	
	@Autowired
	private MonitoramentoService service;
	
	@GetMapping
	public ResponseEntity<?> findLastObject(){
		Monitoramento obj = service.findLastObject();
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Monitoramento obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().build();
	}
	
}
