package com.maianesamara.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maianesamara.dto.ContaDto;
import com.maianesamara.entidade.Conta;
import com.maianesamara.map.ContaMap;
import com.maianesamara.services.ContaService;

import io.swagger.annotations.Api;

@Api(tags = "Contas")
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
	
	@PostMapping
	public ResponseEntity<ContaDto> inserirConta(@Valid @RequestBody ContaDto contaDto){
		contaDto = service.inserirConta(contaDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(contaDto.getId()).toUri();
		return ResponseEntity.created(uri).body(contaDto);
	}
	
	@PutMapping(value = "/{idConta}")
	public ResponseEntity<ContaDto> atualizarConta(@Valid @PathVariable Long idConta, @RequestBody ContaDto contaDto){
		ContaDto contaDtoAtualização = contaMap.toModel(service.buscarContaId(idConta));
		BeanUtils.copyProperties(contaDto, contaDtoAtualização , "id", "dataNascimento");
		contaDto = service.inserirConta(contaDtoAtualização);
		return ResponseEntity.ok().body(contaDto);	
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deletarTodos() {
		service.deletarTodos();
		return ResponseEntity.noContent().build();
	}
	
}

