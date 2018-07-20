package br.com.secretariaadmco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.secretariaadmco.model.Membros;
import br.com.secretariaadmco.service.MembroService;

@RestController
@RequestMapping(value = "/secretaria")
public class SecretariaController {

	@Autowired
	MembroService membroService;

	@RequestMapping(method = RequestMethod.POST, value = "/membro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Membros> cadastrarMembro(@RequestBody Membros membro) {
		Membros membroCadastrado = membroService.salvar(membro);

		return new ResponseEntity<>(membroCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/membro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Membros> alterarMembro(@RequestBody Membros membro) {
		Membros membroPesquisado = membroService.alterar(membro);

		return new ResponseEntity<>(membroPesquisado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/membro/{id}")
	public ResponseEntity<Membros> excluirMembro(@PathVariable Integer id) {
		Membros membroPesquisado = membroService.buscarPorId(id);
		membroService.excluir(membroPesquisado);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/membro/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Membros> buscarPorId(@PathVariable Integer id) {
		Membros membroPesquisado = membroService.buscarPorId(id);

		return new ResponseEntity<>(membroPesquisado, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/membro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Membros>> listarMembros() {
		List<Membros> lista = membroService.busucarTodos();

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/membro/listar/{congregacao}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Membros>> listarMembrosPorCongregacao(@PathVariable String congregacao) {
		List<Membros> lista = membroService.listarMembrosPorCongregacao(congregacao);

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/membro/cogregacao/{congregacao}/{situacao}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> relatorioDeMebrosCongregacoes(@PathVariable String congregacao, @PathVariable String situacao) {
		Integer valor = membroService.relatorioDeMebrosCongregacoes(congregacao, situacao);

		return new ResponseEntity<>(valor, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/membro/campo/{situacao}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> relatorioDeMebrosCampo(@PathVariable String situacao) {
		Integer valor = membroService.relatorioDeMebrosCampo(situacao);

		return new ResponseEntity<>(valor, HttpStatus.OK);
	}

}
