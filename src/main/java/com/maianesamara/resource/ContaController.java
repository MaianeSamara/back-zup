package com.maianesamara.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maianesamara.dto.ContaDto;
import com.maianesamara.entidade.Conta;
import com.maianesamara.map.ContaMap;
import com.maianesamara.services.ContaService;

@RestController
@RequestMapping(value = "/contas")
public class ContaController {

	@Autowired
	private ContaService service;
	
	@Autowired
	private ContaMap contaMap;
	
	@GetMapping
	public ResponseEntity<List<ContaDto>> buscar(){
		List<ContaDto> contas = service.buscarContas();
		return ResponseEntity.ok().body(contas);
	}
	
	@GetMapping(value = "/{idConta}")
	public ResponseEntity<ContaDto> buscarContaId(@PathVariable Long idConta){
		Conta conta = service.buscarContaId(idConta);
		ContaDto contaDto = contaMap.toModel(conta);
		return ResponseEntity.ok().body(contaDto);
	}
	
	@DeleteMapping(value = "/{idConta}")
	public ResponseEntity<Void> deletarConta(@PathVariable Long idConta){
		service.deletarConta(idConta);
		return ResponseEntity.noContent().build();
	}
}

