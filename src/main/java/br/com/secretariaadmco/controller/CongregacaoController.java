package br.com.secretariaadmco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.secretariaadmco.model.Congregacoes;
import br.com.secretariaadmco.model.Membros;
import br.com.secretariaadmco.service.CongregacaoService;

@RestController
@RequestMapping(value = "/congregacoes")
public class CongregacaoController {

	@Autowired
	CongregacaoService congregacaoService;

	@RequestMapping(method = RequestMethod.GET, value = "/lista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Congregacoes>> listarCongregacoes() {

		List<Congregacoes> lista = congregacaoService.listarCongregacoes();

		return new ResponseEntity<>(lista, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Congregacoes> cadastrarMembro(@RequestBody Congregacoes congregacao) {
		Congregacoes congregacaoCadastrada = congregacaoService.cadastrarCongregacao(congregacao);

		return new ResponseEntity<>(congregacaoCadastrada, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/excluir", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Congregacoes> excluir(@RequestBody Integer id) {
		Congregacoes congregacaoPesquisada = congregacaoService.buscarCongregacao(id);
		congregacaoService.excluir(congregacaoPesquisada);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
