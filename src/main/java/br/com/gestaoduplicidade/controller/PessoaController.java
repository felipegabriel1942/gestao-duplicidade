package br.com.gestaoduplicidade.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.event.SelectEvent;

import br.com.gestaoduplicidade.dto.PessoaDTO;
import br.com.gestaoduplicidade.model.Pessoa;
import br.com.gestaoduplicidade.service.PessoaService;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class PessoaController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	@Named("pessoaService")
	@Getter
	@Setter
	private PessoaService ps;

	@Getter
	@Setter
	private PessoaDTO pessoa;

	@Getter
	@Setter
	private List<PessoaDTO> lista;

	@PostConstruct
	public void init() {
		lista = ps.listarTodos();
	}
	

	public void preencherCard(SelectEvent event) {
		ps.preencherCard(((PessoaDTO) event.getObject()).getId());
	}

	public String paginaListarDados() {
		return "listar?faces-redirect=true";
	}

	public String paginaCadastro() {
		return "cadastrar?faces-redirect=true";
	}

	public String voltarParaIndex() {
		return "index?faces-redirect=true";
	}

}
