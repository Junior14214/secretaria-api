package br.com.secretariaadmco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Dizimistas {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String tipo_membro;
	private double valor;
	private String data;
	private String congregacao;
	private int tipo;

}
