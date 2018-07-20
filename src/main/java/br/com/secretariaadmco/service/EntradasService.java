package br.com.secretariaadmco.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.secretariaadmco.model.Entradas;
import br.com.secretariaadmco.repository.EntradasRepository;

@Service
public class EntradasService {
	
	@Autowired
	EntradasRepository entradasRepository;
	
	Date data = new Date();
	SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	
	public Entradas cadastrar(Entradas entrada) {
		entrada.setData(formatador.format(data.getTime()));
		return entradasRepository.save(entrada);
	}
	
	public List<Entradas> relatorioMensal(String data1, String data2){
		return entradasRepository.relatorioEntradas(data1, data2);
	}

}
