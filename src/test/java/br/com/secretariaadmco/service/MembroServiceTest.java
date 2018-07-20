package br.com.secretariaadmco.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.secretariaadmco.model.Membros;
import br.com.secretariaadmco.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MembroServiceTest {
	
	Membros membros = new Membros();
	
	@Autowired
	MembroService membroService;
	
	@Autowired
	UsuarioService service;
	
	@Test
	public void persistirMembro() {
		
		service.buscarInformacoesUsuarioLogado("OQoZy8WKAFfoNGO96q1NMmTvDtE3");

	}
	
	public void alterarrMembro() {
		membros.setNome("Ailton");
		
		Membros membroPersistido = membroService.salvar(membros);
		
		Membros membroBuscado = membroService.buscarPorId(membroPersistido.getId());
		
		membroBuscado.setNome("Tereza");
		
		membroService.alterar(membroBuscado);
	}
	
	public void excluirrMembro() {
		membros.setNome("Ailton");
		
		Membros membroPersistido = membroService.salvar(membros);
		
		membroService.excluir(membroPersistido);
		
		Assert.assertNull(membroService.buscarPorId(membroPersistido.getId()));
	}
	
	
	public void buscarMembroPersistido() {
		membros.setNome("Ailton");
		
		Membros membroPersistido = membroService.salvar(membros);
		
		membroService.buscarPorId(membroPersistido.getId());
		
		Assert.assertEquals(membroPersistido, membros);
	}

	public void buscarTodos() {
		List<Membros> lista =  membroService.busucarTodos();
		
		System.out.println(lista.size());
		
		if(lista.size() > 1);
		

	}
}
