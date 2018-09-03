package br.com.gestaoduplicidade.dto;

import java.util.Calendar;

import lombok.Getter;
import lombok.Setter;

public class PessoaDTO {

	@Getter
	@Setter
	private Integer codigo;

	@Getter
	@Setter
	private String nome;

	@Getter
	@Setter
	private Calendar nascimento;
	
	@Getter
	@Setter
	private String celular;

	public PessoaDTO(Integer codigo, String nome, Calendar nascimento, String celular) {
		this.codigo = codigo;
		this.nome = nome;
		this.nascimento = nascimento;
		this.celular = celular;
	}
	
	
}
