package com.maianesamara.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
