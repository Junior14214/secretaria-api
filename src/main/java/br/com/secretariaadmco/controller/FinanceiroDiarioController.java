package br.com.secretariaadmco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.secretariaadmco.model.FinanceiroDiario;
import br.com.secretariaadmco.service.FinanceiroDiarioService;

@RestController
@RequestMapping(value = "/financeiro")
public class FinanceiroDiarioController {

	@Autowired
	FinanceiroDiarioService financeiroDiarioService;

	@RequestMapping(value = "/diario/{congregacao}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FinanceiroDiario> relatorioFinanceiroDiario(@PathVariable String congregacao) {
		FinanceiroDiario congregacaoPesquisada = financeiroDiarioService.pesquisarCongregacao(congregacao);

		return new ResponseEntity<>(congregacaoPesquisada, HttpStatus.CREATED);
	}

}
