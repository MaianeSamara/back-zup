package com.maianesamara.map;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maianesamara.dto.ContaDto;
import com.maianesamara.entidade.Conta;

@Component
public class ContaMap {

	@Autowired
	private ModelMapper modelMapper;

	public List<ContaDto> toCollectionModel(List<Conta> contas) {
		return contas.stream().map(conta -> toModel(conta)).collect(Collectors.toList());

	}

	public ContaDto toModel(Conta conta) {
		return modelMapper.map(conta, ContaDto.class);
	}
	
	public Conta toConta(ContaDto conta) {
		return modelMapper.map(conta, Conta.class);
	}
}
