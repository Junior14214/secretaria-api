package br.com.secretariaadmco.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.secretariaadmco.model.Entradas;
import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntradasServiceTest {
	
	Entradas entrada = new Entradas();
	
	@Autowired
	EntradasService entradasService;

	public void cadastrarEntrada() {
		entrada.setOutros(116.85);
		entrada.setDescricao("Doação");
		
		entradasService.cadastrar(entrada);
	}
	
	@Test
	public void relatorioMensal() {
		List<Entradas> lista = entradasService.relatorioMensal("20/05/2018", "20/05/2018");
		
		Assert.assertEquals(2, lista.size());
	}
}
