package br.com.secretariaadmco.agendador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.secretariaadmco.model.Congregacoes;
import br.com.secretariaadmco.model.Dizimistas;
import br.com.secretariaadmco.model.Financeiro;
import br.com.secretariaadmco.model.FinanceiroDiario;
import br.com.secretariaadmco.service.CongregacaoService;
import br.com.secretariaadmco.service.DizimistasService;
import br.com.secretariaadmco.service.FinanceiroDiarioService;

@Component
@EnableScheduling
public class VerificadorDePegamentos {

	private final long SEGUNDO = 1000;
	private final long MINUTO = SEGUNDO * 60;
	private final long HORA = MINUTO * 60;

	@Autowired
	DizimistasService dizimistaService;

	@Autowired
	CongregacaoService congregacaoService;
	
	@Autowired
	FinanceiroDiarioService financeiroDiarioService;
	
	Financeiro valores = new Financeiro();
	FinanceiroDiario financeiroDiario = new FinanceiroDiario();

	Congregacoes cli = new Congregacoes();
	
	Date data = new Date();
	SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd");
	SimpleDateFormat formatador2 = new SimpleDateFormat("yyyy/MM");


	List<Congregacoes> teste;

	List<Dizimistas> resultado;
	List<Congregacoes> congregacoes;

	double totalDizimos;
	double totalOfertas;
	double totalOfertasEspeciais;
	double totalOutros;
	double totalSaidas;
	double totalGeral;
//
//	@Scheduled(cron = "0/5 * * * * *")
//	public void verificaPorMes() {
//
//		congregacoes = congregacaoService.listarCongregacoes();
//		// System.out.println(congregacoes.get(0).getCongregacao());
//
//		int i = 0;
//
//		while (i < congregacoes.size()) {
//			totalDizimos = dizimistaService.somarValores(1, congregacoes.get(i).getCongregacao(), "2018/07/01", "2018/07/01");
//			totalOfertas = dizimistaService.somarValores(2, congregacoes.get(i).getCongregacao(), "2018/07/01", "2018/07/01");
//			totalOfertasEspeciais = dizimistaService.somarValores(3, congregacoes.get(i).getCongregacao(), "2018/07/01", "2018/07/01");
//			totalOutros = dizimistaService.somarValores(4, congregacoes.get(i).getCongregacao(), "2018/07/01", "2018/07/01");
//			totalSaidas = dizimistaService.somarValores(5, congregacoes.get(i).getCongregacao(), "2018/07/01", "2018/07/01")*-1;
//			
//			totalGeral = totalDizimos + totalOfertas + totalOfertasEspeciais + totalOutros - totalSaidas;
//			
//			valores.setCongregacao(congregacoes.get(i).getCongregacao());
//			valores.setEntradas(totalDizimos + totalOfertas + totalOfertasEspeciais + totalOutros);
//			valores.setSaidas(totalSaidas);
//			valores.setTotal(totalGeral); 
//			valores.setData_inicial(formatador.format(data));
//			valores.setData_final(formatador2.format(data) + "/1");
//		
//			financeiroService.rotinaMensal(valores);
//			
//			System.out.println("Dizimos: " + totalDizimos + " Oferas: " + totalOfertas + " Ofertas esp: " + totalOfertasEspeciais
//					+ " Outros: " + totalOutros + " Saidas: " + totalSaidas + " Total Geral: " + totalGeral);
//			i++;
//		}
//
//	}
	
	@Scheduled(cron = "0 0 0 * * *")
	public void verificaPorDia() {

		congregacoes = congregacaoService.listarCongregacoes();
		// System.out.println(congregacoes.get(0).getCongregacao());

		int i = 0;

		while (i < congregacoes.size()) {
			totalDizimos = dizimistaService.somarValores(1, congregacoes.get(i).getCongregacao(), formatador2.format(data) + "/01", formatador.format(data));
			totalOfertas = dizimistaService.somarValores(2, congregacoes.get(i).getCongregacao(), formatador2.format(data) + "/01", formatador.format(data));
			totalOfertasEspeciais = dizimistaService.somarValores(3, congregacoes.get(i).getCongregacao(), formatador2.format(data) + "/1", formatador.format(data));
			totalOutros = dizimistaService.somarValores(4, congregacoes.get(i).getCongregacao(), formatador2.format(data) + "/01", formatador.format(data));
			totalSaidas = dizimistaService.somarValores(5, congregacoes.get(i).getCongregacao(), formatador2.format(data) + "/01", formatador.format(data))*-1;
			
			totalGeral = totalDizimos + totalOfertas + totalOfertasEspeciais + totalOutros - totalSaidas;
			
			financeiroDiario.setId(i+1);
			financeiroDiario.setCongregacao(congregacoes.get(i).getCongregacao());
			financeiroDiario.setEntradas(totalDizimos + totalOfertas + totalOfertasEspeciais + totalOutros);
			financeiroDiario.setSaidas(totalSaidas);
			financeiroDiario.setTotal(totalGeral); 
			financeiroDiario.setData(formatador.format(data));
		
			financeiroDiarioService.salvar(financeiroDiario);
			
			System.out.println("Congregacao: " + congregacoes.get(i).getCongregacao() + "Dizimos: " + totalDizimos + " Oferas: " + totalOfertas + " Ofertas esp: " + totalOfertasEspeciais
					+ " Outros: " + totalOutros + " Saidas: " + totalSaidas + " Total Geral: " + totalGeral);
			i++;
		}

	}

}
