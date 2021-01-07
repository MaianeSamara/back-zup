package com.maianesamara.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maianesamara.dto.ContaDto;
import com.maianesamara.entidade.Conta;
import com.maianesamara.map.ContaMap;
import com.maianesamara.repository.ContaRepository;
import com.maianesamara.services.exception.EntidadeNaoEncontrada;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;
	
	@Autowired
	private ContaMap contaMap;
	
	public List<ContaDto> buscarContas(){
		return contaMap.toCollectionModel(repository.findAll());
	}
	
	public Conta buscarContaId(Long idConta) {
		return repository.findById(idConta).orElseThrow(() -> new EntidadeNaoEncontrada("Conta de Id: " + idConta + ", não cadastrada!."));
	}
}
