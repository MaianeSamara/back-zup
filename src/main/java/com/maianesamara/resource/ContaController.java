package com.maianesamara.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maianesamara.dto.ContaDto;
import com.maianesamara.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaController {

	@Autowired
	private ContaService service;
	
	@GetMapping
	public ResponseEntity<List<ContaDto>> buscar(){
		List<ContaDto> contas = service.buscarContas();
		return ResponseEntity.ok().body(contas);
	}
}

