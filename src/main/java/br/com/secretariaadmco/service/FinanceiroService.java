package br.com.secretariaadmco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.secretariaadmco.model.Financeiro;
import br.com.secretariaadmco.repository.FinanceiroRepository;

@Service
public class FinanceiroService {

	@Autowired
	FinanceiroRepository financeiroRepository;

	public void rotinaMensal(Financeiro valores) {
		int id = financeiroRepository.sdfsd();
		valores.setId(id+1);
		financeiroRepository.save(valores);
	}
	
	public void rotinaDiaria(Financeiro valores) {
		int id = 1;
		valores.setId(id+1);
		financeiroRepository.save(valores);
	}

}
