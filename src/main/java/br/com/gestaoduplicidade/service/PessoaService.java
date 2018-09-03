package br.com.gestaoduplicidade.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.gestaoduplicidade.dto.PessoaDTO;
import br.com.gestaoduplicidade.repository.PessoaRepository;

@Named("pessoaService")
@LocalBean
@Stateless
public class PessoaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	@Named("pessoaRepository")
	private PessoaRepository pr;

	public List<PessoaDTO> listarTodos() {
		if (pr.listarPessoas() != null) {
			return pr.listarPessoas();
		}

		return null;
	}
}
