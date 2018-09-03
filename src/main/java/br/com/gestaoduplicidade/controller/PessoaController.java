package br.com.gestaoduplicidade.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.com.gestaoduplicidade.dto.PessoaDTO;
import br.com.gestaoduplicidade.service.PessoaService;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class PessoaController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	@Named("pessoaService")
	@Getter
	@Setter
	private PessoaService ps;
	
	@Getter
	@Setter
	private List<PessoaDTO> lista;
	
	@PostConstruct
	public void init() {
		lista = ps.listarTodos();
	}
	
	public String listarDados() {
		return "lista";
	}
}
