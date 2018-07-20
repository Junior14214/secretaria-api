package br.com.secretariaadmco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Usuario {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	public String email;
	private String sobrenome;
	private String congregacao;
	private String endereco;
	private String foto;
	private String uid;
	private String permissao;

}
