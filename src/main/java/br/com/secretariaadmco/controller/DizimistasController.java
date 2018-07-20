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

import br.com.secretariaadmco.model.Dizimistas;
import br.com.secretariaadmco.service.DizimistasService;

@RestController
@RequestMapping(value = "/secretaria")
public class DizimistasController {

	@Autowired
	DizimistasService dizimistasService;

	@RequestMapping(method = RequestMethod.POST, value = "/dizimista", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Dizimistas>> salvar(@RequestBody List<Dizimistas> dizimista) {
		List<Dizimistas> dizimistaSalvo = dizimistasService.salvar(dizimista);

		return new ResponseEntity<>(dizimistaSalvo, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dizimista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Dizimistas>> listarTodos() {
		List<Dizimistas> lista = dizimistasService.buscarTodos();

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dizimista/{tipo}/{congregacao}/{data1}/{data2}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Dizimistas>> relatorioMensal(@PathVariable Integer tipo,
			@PathVariable String congregacao, @PathVariable String data1, @PathVariable String data2) {

		StringBuilder data1Formatada = new StringBuilder(data1);
		data1Formatada.insert(4, '/');
		data1Formatada.insert(7, '/');
		System.out.println(data1Formatada);

		StringBuilder data2Formatada = new StringBuilder(data2);
		data2Formatada.insert(4, '/');
		data2Formatada.insert(7, '/');
		System.out.println(data2Formatada);

		List<Dizimistas> lista = dizimistasService.relatorioMensal(tipo, congregacao, data1Formatada.toString(),
				data2Formatada.toString());

		return new ResponseEntity<>(lista, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/dizimista/total/{tipo}/{congregacao}/{data1}/{data2}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> somarValores(@PathVariable Integer tipo, @PathVariable String congregacao,
			@PathVariable String data1, @PathVariable String data2) {

		StringBuilder data1Formatada = new StringBuilder(data1);
		data1Formatada.insert(4, '/');
		data1Formatada.insert(7, '/');
		System.out.println(data1Formatada);

		StringBuilder data2Formatada = new StringBuilder(data2);
		data2Formatada.insert(4, '/');
		data2Formatada.insert(7, '/');
		System.out.println(data2Formatada);

		Double total = dizimistasService.somarValores(tipo, congregacao, data1Formatada.toString(),
				data2Formatada.toString());

		if (total == null) {
			return new ResponseEntity<>(0.0, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(total, HttpStatus.CREATED);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/repasseCongregacoes/{tipo}/{data1}/{data2}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object>> relatorioGeralSede(@PathVariable Integer tipo, @PathVariable String data1,
			@PathVariable String data2) {

		StringBuilder data1Formatada = new StringBuilder(data1);
		data1Formatada.insert(4, '/');
		data1Formatada.insert(7, '/');
		System.out.println(data1Formatada);

		StringBuilder data2Formatada = new StringBuilder(data2);
		data2Formatada.insert(4, '/');
		data2Formatada.insert(7, '/');
		System.out.println(data2Formatada);

		List<Object> lista = dizimistasService.relatorioGeralSede(tipo, data1Formatada.toString(),
				data2Formatada.toString());

		return new ResponseEntity<>(lista, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/relatorio/congregacao/{congregacao}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object>> relatorioDeEntradasCongregacoes(@PathVariable String congregacao) {
		List<Object> lista = dizimistasService.relatorioDeEntradasCongregacoes(congregacao);

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/relatorio/campo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Object>> relatorioDeEntradasCampo() {
		List<Object> lista = dizimistasService.relatorioDeEntradasCampo();

		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

}
