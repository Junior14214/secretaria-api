package br.com.secretariaadmco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.secretariaadmco.model.Congregacoes;
import br.com.secretariaadmco.repository.CongregacaoRepository;

@Service
public class CongregacaoService {

	@Autowired
	CongregacaoRepository congregacaoRepository;

	public List<Congregacoes> listarCongregacoes() {
		return congregacaoRepository.findAll();
	}

	public Congregacoes buscarCongregacao(Integer id) {
		return congregacaoRepository.findOne(id);
	}

	public Congregacoes cadastrarCongregacao(Congregacoes congregacao) {
		return congregacaoRepository.save(congregacao);
	}

	public void excluir(Congregacoes congregacao) {
		congregacaoRepository.delete(congregacao);
	}

}
