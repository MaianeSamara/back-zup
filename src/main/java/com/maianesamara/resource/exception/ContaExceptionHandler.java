package com.maianesamara.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.maianesamara.services.exception.EntidadeNaoEncontrada;

@ControllerAdvice
public class ContaExceptionHandler {

	@ExceptionHandler(EntidadeNaoEncontrada.class)
	public ResponseEntity<Problema> objectNotFound(EntidadeNaoEncontrada e, HttpServletRequest request) {

		Problema problema = new Problema(HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problema);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Problema> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

		ValidadorDeCampos erros = new ValidadorDeCampos(HttpStatus.BAD_REQUEST.value(), "Erro no cadastro.");

		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			erros.addErro(x.getField(), x.getDefaultMessage());
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
	}
}
