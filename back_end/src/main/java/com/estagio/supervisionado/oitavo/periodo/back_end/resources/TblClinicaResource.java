package com.estagio.supervisionado.oitavo.periodo.back_end.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

import java.util.Optional;

import com.estagio.supervisionado.oitavo.periodo.back_end.domain.TblClinica;
import com.estagio.supervisionado.oitavo.periodo.back_end.services.TblClinicaService;

// Faz a liberação de outro dominio solicitar recursos do domínio abaixo 
@CrossOrigin("*")
// Define essa classe como controlador REST
@RestController
// Faz o mapeamento para acesso aos recursos REST
@RequestMapping(value = "/api/v1/monitoramento/clinica/{idClinica}")
public class TblClinicaResource {

	// Injeta a camada de serviço
	@Autowired
	private TblClinicaService service;

	// Recebe um id pela url e consulta uma clínica no banco de dados
	// Descrição do método no Swagger(OpenAPI)
	@Operation(summary = "Recebe um id pela url e consulta uma clínica no banco de dados.")
	@GetMapping
	public ResponseEntity<?> findClinica(@PathVariable Integer idClinica) {
		// Caso o id não for encontrado é preciso tratar a exceção por isso o Optional, como não foi feito o tratamento de exeção se não existir ele retorna null
		Optional<TblClinica> obj = service.findClinica(idClinica);
		// Faz a construção do objeto no corpo da página 
		return ResponseEntity.ok().body(obj);
	}
	
}
