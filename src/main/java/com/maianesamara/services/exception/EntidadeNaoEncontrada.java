package com.maianesamara.services.exception;

public class EntidadeNaoEncontrada extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EntidadeNaoEncontrada(String message) {
		super(message);
	}
}
