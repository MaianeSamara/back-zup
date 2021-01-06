package com.maianesamara.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maianesamara.dto.ContaDto;
import com.maianesamara.map.ContaMap;
import com.maianesamara.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;
	
	@Autowired
	private ContaMap contaMap;
	
	public List<ContaDto> buscarContas(){
		return contaMap.toCollectionModel(repository.findAll());
	}
}
