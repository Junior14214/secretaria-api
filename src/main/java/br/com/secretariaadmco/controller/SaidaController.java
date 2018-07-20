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

import br.com.secretariaadmco.model.Saidas;
import br.com.secretariaadmco.service.SaidaService;

@RestController
@RequestMapping(value="/saidas")
public class SaidaController {
	
	@Autowired
	SaidaService saidaService;
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Saidas> cadastrar(@RequestBody Saidas saidas){
		Saidas saidaCadastrada = saidaService.cadastrar(saidas);
		
		return new ResponseEntity<>(saidaCadastrada, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{data1}/{data2}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Saidas>> relatorioMensal(@PathVariable String data1, @PathVariable String data2){
		
		StringBuilder data1Formatada = new StringBuilder(data1);
		data1Formatada.insert(2, '/');
		data1Formatada.insert(5, '/');
		System.out.println(data1Formatada);
		
		StringBuilder data2Formatada = new StringBuilder(data2);
		data2Formatada.insert(2, '/');
		data2Formatada.insert(5, '/');
		System.out.println(data2Formatada);
		
		List<Saidas> lista = saidaService.relatorioMensal(data1Formatada.toString(), data2Formatada.toString());
		
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

}
