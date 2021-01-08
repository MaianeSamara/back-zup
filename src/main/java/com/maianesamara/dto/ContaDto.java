package com.maianesamara.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@Length(min = 5, message = "Campo nome tem que ter no mínimo 5 caracteres")
	@NotNull(message = "Nome é Obrigatório.")
	private String nome;
	
	@NotNull(message = "Email é Obrigatório.")
	@Email(message = "Email inválido.")
	private String email;
	
	@NotNull(message = "Campo CPF é Obrigatório.")
	@CPF(message = "CPF inválido.")
	private String cpf;
	
	@NotNull(message = "Data de nascimento é Obrigatório.")
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
	private Date dataNascimento;
}
