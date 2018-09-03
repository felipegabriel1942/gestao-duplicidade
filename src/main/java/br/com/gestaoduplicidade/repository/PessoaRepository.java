package br.com.gestaoduplicidade.repository;

import java.util.List;


import javax.inject.Named;
import javax.persistence.EntityManager;


import br.com.gestaoduplicidade.dto.PessoaDTO;
import br.com.gestaoduplicidade.model.Pessoa;
import br.com.gestaoduplicidade.utils.AbstractEntityBeans;
import br.com.gestaoduplicidade.utils.EntityManagerUtil;

@Named("pessoaRepository")
public class PessoaRepository extends AbstractEntityBeans<Pessoa, Integer> {
	
	
	private EntityManager em;

	public PessoaRepository() {
		super(Pessoa.class, PessoaRepository.class);
		em = EntityManagerUtil.getEntityManager();
	}

	public List<PessoaDTO> listarPessoas() {

		@SuppressWarnings("unchecked")
		List<PessoaDTO> lista = em.createNativeQuery(
				"SELECT p.pkpessoa,p.nomepessoa,p.nascimento,p.celular FROM pessoa p", "PessoaMapping").getResultList();

		return lista;
	}

}
