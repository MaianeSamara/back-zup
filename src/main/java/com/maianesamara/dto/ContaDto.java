package com.maianesamara.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ApiModel(value = "Conta", description = "Representação de uma Conta")

public class ContaDto {
	
	@ApiModelProperty(example = "1")
	private Long id;
	
	@ApiModelProperty(example = "Conta")
	@Length(min = 5, message = "Campo nome tem que ter no mínimo 5 caracteres")
	@NotNull(message = "Nome é Obrigatório.")
	private String nome;
	
	@ApiModelProperty(example = "conta@gmail.com")
	@NotNull(message = "Email é Obrigatório.")
	@Email(message = "Email inválido.")
	private String email;
	
	@ApiModelProperty(example = "12344409000")
	@NotNull(message = "Campo CPF é Obrigatório.")
	@CPF(message = "CPF inválido.")
	private String cpf;
	
	@ApiModelProperty(example = "01/01/2021")
	@NotNull(message = "Data de nascimento é Obrigatório.")
	@JsonFormat(pattern = "dd/MM/yyyy", timezone = "America/Sao_Paulo")
	private Date dataNascimento;
}
