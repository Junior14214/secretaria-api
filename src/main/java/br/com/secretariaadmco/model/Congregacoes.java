package br.com.secretariaadmco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Congregacoes {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String congregacao;
	private String endereco;
	private String dirigente;
	private String telefone;
	private String cnpj;
	private String cidade;
	private String estado;
	private String situacao;
	private String repasse;

}
