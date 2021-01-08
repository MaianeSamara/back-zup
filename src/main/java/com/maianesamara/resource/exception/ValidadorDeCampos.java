package com.maianesamara.resource.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidadorDeCampos extends Problema {

	private List<Campos> erros = new ArrayList<>();

	public ValidadorDeCampos(Integer status, String mensagem) {
		super(status, mensagem);
	}

	public List<Campos> getErros() {
		return erros;
	}

	public void addErro(String campo, String mensagem) {
		erros.add(new Campos(campo, mensagem));
	}
}
