package br.com.secretariaadmco.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.secretariaadmco.model.Membros;
import br.com.secretariaadmco.repository.MembroRepository;

@Service
public class MembroService {

	@Autowired
	MembroRepository membroRepository;

	public Membros salvar(Membros membro) {
		return membroRepository.save(membro);
	}

	public Membros alterar(Membros membro) {
		return membroRepository.save(membro);
	}

	public void excluir(Membros membro) {
		membroRepository.delete(membro);
	}

	public Membros buscarPorId(int id) {
		return membroRepository.findOne(id);
	}

	public List<Membros> busucarTodos() {
		return membroRepository.findAll();
	}

	public List<Membros> listarMembrosPorCongregacao(String congregacao) {
		return membroRepository.listarMembrosPorCongregacao(congregacao);
	}
	
	public Integer relatorioDeMebrosCongregacoes(String congregacao, String situacao) {
		return membroRepository.relatorioDeMebrosCongregacoes(congregacao, situacao);
	}
	
	public Integer relatorioDeMebrosCampo(String situacao) {
		return membroRepository.relatorioDeMebrosCampo(situacao);
	}
}
