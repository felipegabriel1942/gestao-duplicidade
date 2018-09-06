package br.com.gestaoduplicidade.dto;



import lombok.Getter;
import lombok.Setter;

public class PessoaDTO {

	@Getter
	@Setter
	private Integer id;

	@Getter
	@Setter
	private String nome;
	
	@Getter
	@Setter
	private String nomeMae;
	
	@Getter
	@Setter
	private String nomePai;
	
	@Getter
	@Setter
	private String rua;
	
	@Getter
	@Setter
	private String numero;
	
	@Getter
	@Setter
	private String bairro;
	
	@Getter
	@Setter
	private String cidade;
	
	@Getter
	@Setter
	private String estado;
	
	@Getter
	@Setter
	private String celular1;
	
	@Getter
	@Setter
	private String celular2;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String cpf;
	
	@Getter
	@Setter
	private String sexo;
	
	
	public PessoaDTO() {
		
	}
	
	
}
