package br.com.secretariaadmco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.secretariaadmco.model.Saidas;
import br.com.secretariaadmco.repository.SaidaRepository;

@Service
public class SaidaService {
	
	@Autowired
	SaidaRepository saidaRepository;
	
	public Saidas cadastrar(Saidas saidas) {
		return saidaRepository.save(saidas);
	}
	
	public List<Saidas> relatorioMensal(String data1, String data2) {
		return saidaRepository.relatorioMensal(data1, data2);
	}

}
