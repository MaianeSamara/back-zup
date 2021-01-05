package com.maianesamara.entidade;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Conta {

	@EqualsAndHashCode.Include
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private Date dataNascimento;
}
