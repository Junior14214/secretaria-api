package br.com.secretariaadmco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.secretariaadmco.model.FinanceiroDiario;
import br.com.secretariaadmco.repository.FinanceiroDiarioRepository;

@Service
public class FinanceiroDiarioService {

	@Autowired
	FinanceiroDiarioRepository financeiroDiarioRepository;


	public FinanceiroDiario salvar(FinanceiroDiario valores) {
		return financeiroDiarioRepository.save(valores);
		
	}
	
	public FinanceiroDiario pesquisarCongregacao(String congregacao) {
		return financeiroDiarioRepository.pesquisarCongregacao(congregacao);
	}

}
