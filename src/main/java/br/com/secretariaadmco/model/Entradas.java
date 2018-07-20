package br.com.secretariaadmco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Entradas {
	
	@Id
	@GeneratedValue
	private Integer id;
	private double ofertas;
	private double outros;
	private String descricao;
	private double saidas;
	private String data;
	

}
