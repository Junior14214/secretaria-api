package br.com.secretariaadmco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Saidas {

	@Id
	@GeneratedValue
	private Integer id;
	private String descricao;
	private double valor;
	private String data;
}
