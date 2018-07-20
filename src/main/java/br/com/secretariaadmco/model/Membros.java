package br.com.secretariaadmco.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;
import org.springframework.test.context.TestExecutionListeners;

import lombok.Data;

@Entity
@Data
public class Membros {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer rol;
	private String nome;
	private String pai;
	private String mae;
	@Column(length=1)
	private String sexo;
	private String data_de_nascimento;
	private String profissao;
	private String telefone;
	private String rg;
	private String cpf;
	private String pais;
	private String naturalidade;
	private String estado_civil;
	private String endereco;
	private String bairro;
	private String cidade;
	private String cep;
	@Column(name="aguas")
	private String batismo_nas_aguas;
	@Column(name="espirito")
	private String batismo_no_espirito_santo;
	@Column(name="inicio")
	private String data_de_inicio;
	private String dirigente;
	private String cargo;
	private String congregacao;
	private String historico;
	private String observacao;
	private String foto;
	private String conjuje;
	private String nascimento_conjuje;
	private String situacao;
	

}
