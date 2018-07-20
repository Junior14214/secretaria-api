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

import br.com.secretariaadmco.model.Entradas;
import br.com.secretariaadmco.service.EntradasService;

@RestController
@RequestMapping(value="financeiro")
public class EntradasController {
	
	@Autowired
	EntradasService entradasService;
	
	@RequestMapping(method = RequestMethod.POST ,value="/entrada", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Entradas> cadastrarEntrada(@RequestBody Entradas entrada){
		Entradas entradaCadastrada = entradasService.cadastrar(entrada);
		
		return new ResponseEntity<>(entradaCadastrada, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/relatorio/{data1}/{data2}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Entradas>> relatorioMensal(@PathVariable String data1, @PathVariable String data2){
		
		StringBuilder data1Formatada = new StringBuilder(data1);
		data1Formatada.insert(2, '/');
		data1Formatada.insert(5, '/');
		
		StringBuilder data2Formatada = new StringBuilder(data2);
		data2Formatada.insert(2, '/');
		data2Formatada.insert(5, '/');
		
		List<Entradas> lista = entradasService.relatorioMensal(data1Formatada.toString(), data2Formatada.toString());
		
		return new ResponseEntity<> (lista, HttpStatus.CREATED);
	}

}
