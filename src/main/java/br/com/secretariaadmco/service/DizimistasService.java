package br.com.secretariaadmco.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.secretariaadmco.model.Dizimistas;
import br.com.secretariaadmco.repository.DizimistasRepository;

@Service
public class DizimistasService {

	@Autowired
	DizimistasRepository dizimistasRepository;

	Date data = new Date();
	SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

	public List<Dizimistas> salvar(List<Dizimistas> dizimista) {
		// dizimista.setData(formatador.format(data.getTime()));
		return dizimistasRepository.save(dizimista);
	}

	public List<Dizimistas> buscarTodos() {
		return dizimistasRepository.findAll();
	}

	public List<Dizimistas> relatorioMensal(Integer tipo, String congregacao, String data1, String data2) {
		return dizimistasRepository.relatorioMensal(tipo, congregacao, data1, data2);
	}

	public Double somarValores(Integer tipo, String congregacao, String data1, String data2) {
		return dizimistasRepository.somarValores(tipo, congregacao, data1, data2);
	}

	public List<Object> relatorioGeralSede(Integer tipo, String data1, String data2) {
		return dizimistasRepository.relatorioGeralSede(tipo, data1, data2);
	}

	public List<Object> relatorioDeEntradasCongregacoes(String congregacao) {
		return dizimistasRepository.relatorioDeEntradasCongregacoes(congregacao);
	}

	public List<Object> relatorioDeEntradasCampo() {
		return dizimistasRepository.relatorioDeEntradasCampo();
	}

}
