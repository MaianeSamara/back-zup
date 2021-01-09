package com.maianesamara.doc;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.maianesamara.dto.ContaDto;
import com.maianesamara.resource.exception.Problema;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface ContaResourceDocumentacao {

	@ApiOperation("Lista todas as contas.")
	public ResponseEntity<List<ContaDto>> buscar();
	
	@ApiOperation("Busca uma conta por ID")
    @ApiResponses({
        @ApiResponse(code = 400, message = "Id da conta não cadastrada", response = Problema.class),
        @ApiResponse(code = 404, message = "Id da conta não encontrado", response = Problema.class)
    })
	public ResponseEntity<ContaDto> buscarContaId(@ApiParam(value = "ID de um grupo", example = "1") @PathVariable Long idConta);
	
	@ApiOperation("Exclui uma conta por ID")
    @ApiResponses({
        @ApiResponse(code = 204, message = "Conta excluído"),
        @ApiResponse(code = 404, message = "Conta não encontrado", response = Problema.class)
    })
	public ResponseEntity<Void> deletarConta(@ApiParam(value = "ID de um grupo", example = "1") @PathVariable Long idConta);
	
	@ApiOperation("Cadastra uma conta")
    @ApiResponses({
        @ApiResponse(code = 201, message = "Conta cadastrada"),
    })
	public ResponseEntity<ContaDto> inserirConta(@ApiParam(name = "corpo", value = "Representação de um novo grupo") @Valid @RequestBody ContaDto contaDto);
	
	@ApiOperation("Atualiza uma conta por ID")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Conta atualizado"),
        @ApiResponse(code = 404, message = "Conta não encontrado", response = Problema.class)
    })
	public ResponseEntity<ContaDto> atualizarConta(
			@ApiParam(value = "ID de uma conta", example = "1")Long id, 
			@ApiParam(name = "corpo", value = "Representação de uma conta com os novos dados")
			@Valid @PathVariable Long idConta, @RequestBody ContaDto contaDto);
	
	@ApiOperation("Exclui contas")
    @ApiResponses({
        @ApiResponse(code = 204, message = "Conta excluído"),
    })
	public ResponseEntity<Void> deletarTodos();
}
