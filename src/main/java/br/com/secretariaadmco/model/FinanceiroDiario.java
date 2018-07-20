package br.com.secretariaadmco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class FinanceiroDiario {
	
	@Id
	private Integer id;
	private String congregacao;
	private String data;
	private Double entradas;
	private Double saidas;
	private Double total;

}
