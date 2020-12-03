package com.estagio.supervisionado.oitavo.periodo.back_end.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estagio.supervisionado.oitavo.periodo.back_end.domain.VwTblClinicaDados;
import com.estagio.supervisionado.oitavo.periodo.back_end.services.VwTblClinicaDadosService;

import io.swagger.v3.oas.annotations.Operation;

// Faz a liberação de outro dominio solicitar recursos do domínio abaixo 
@CrossOrigin("*")
// Define essa classe como controlador REST
@RestController
// Faz o mapeamento para acesso aos recursos REST
@RequestMapping(value="/api/v1/monitoramento")
public class VwTblClinicaDadosResource {
	
	// Injeta a camada de serviço
	@Autowired
	private VwTblClinicaDadosService service;
	
	// Consulta a informação mais recente do banco de dados
		// Descrição do método no Swagger(OpenAPI)
		@Operation(summary = "Consulta a informação mais recente do banco de dados.")
		@GetMapping
		public ResponseEntity<?> findLastData(){
			VwTblClinicaDados obj = service.findLastData();
			// Faz a construção do objeto no corpo da página 
			return ResponseEntity.ok().body(obj);
		}
	
}
