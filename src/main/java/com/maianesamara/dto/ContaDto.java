package com.maianesamara.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ContaDto {
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private Date dataNascimento;
}
