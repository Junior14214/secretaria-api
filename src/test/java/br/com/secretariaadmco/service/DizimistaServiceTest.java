package br.com.secretariaadmco.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.secretariaadmco.model.Congregacoes;
import br.com.secretariaadmco.model.Dizimistas;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DizimistaServiceTest {
	
	Dizimistas dizimista = new Dizimistas();
	
	@Autowired
	CongregacaoService congregacaoService;

	@Test
	public void salvarDizimista() {
		Congregacoes congregacoes = new Congregacoes();
		
		congregacaoService.listarCongregacoes();
	}
	
	
}
