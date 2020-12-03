package com.estagio.supervisionado.oitavo.periodo.back_end.resources;

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

import com.estagio.supervisionado.oitavo.periodo.back_end.domain.TblClinicaDados;
import com.estagio.supervisionado.oitavo.periodo.back_end.services.TblClinicaDadosService;

import io.swagger.v3.oas.annotations.Operation;

// Faz a liberação de outro dominio solicitar recursos do domínio abaixo 
@CrossOrigin("*")
// Define essa classe como controlador REST
@RestController
// Faz o mapeamento para acesso aos recursos REST
@RequestMapping(value = "/api/v1/monitoramento")
public class TblClinicaDadosResource {

	// Injeta a camada de serviço
	@Autowired
	private TblClinicaDadosService service;

	// Faz o mapeamento para acesso a média da temperatura
	// Descrição do método no Swagger(OpenAPI)
	@Operation(summary = "Consulta os registros da última hora e retorna a média da temperatura.")
	@GetMapping(value = "/media")
	public ResponseEntity<?> findAverage(){
		List<TblClinicaDados> objs = new ArrayList<>();
		Double mediaTemperatura = 0.0;
		objs = service.findAverage();
		for (int i = 0; i < objs.size(); i++) {
			mediaTemperatura += objs.get(i).getTemperatura();
		}
		mediaTemperatura = mediaTemperatura / objs.size() ;
		// Faz a construção do média no corpo da página
		return ResponseEntity.ok().body(mediaTemperatura);
	}

	// Recebe e salva dados novos no banco de dados
	// Descrição do método no Swagger(OpenAPI)
	@Operation(summary = "Recebe e salva dados novos no banco de dados.")
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody TblClinicaDados obj) {
		// Salva o objeto no banco de dados
		obj = service.insert(obj);
		return ResponseEntity.ok().build();
	}

}
