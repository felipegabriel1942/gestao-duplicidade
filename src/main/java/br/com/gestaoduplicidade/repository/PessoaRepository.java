package br.com.gestaoduplicidade.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.gestaoduplicidade.dto.PessoaDTO;
import br.com.gestaoduplicidade.model.Pessoa;
import br.com.gestaoduplicidade.utils.EntityManagerUtil;

@Named("pessoaRepository")
public class PessoaRepository {

	private EntityManager em;

	public PessoaRepository() {

		em = EntityManagerUtil.getEntityManager();
	}

	public List<PessoaDTO> listarPessoasTabelaPrincipal() {

		@SuppressWarnings("unchecked")
		List lista = em.createNativeQuery("select id, nome from pessoa;").getResultList();

		return converterRetornoConsulta(lista);
	}

	public PessoaDTO preencherCardDeDados(Integer id) {
		Object[] pessoa = (Object[]) em.createNativeQuery("select * from pessoa where id = " + id + ";")
				.getSingleResult();

		return this.setarDadosNoCard((Integer) pessoa[0], (String) pessoa[1], (String) pessoa[2], (String) pessoa[3],
				(String) pessoa[4], (String) pessoa[5], (String) pessoa[6], (String) pessoa[7], (String) pessoa[8],
				(String) pessoa[9], (String) pessoa[10], (String) pessoa[11], (String) pessoa[12], (String) pessoa[13]);

	}

	public List<PessoaDTO> converterRetornoConsulta(List<Object[]> resultList) {
		List<PessoaDTO> lista = new ArrayList<PessoaDTO>();
		for (Object[] objeto : resultList) {
			lista.add(this.setarDadosNaTabela((Integer) objeto[0], (String) objeto[1]));
		}
		return lista;
	}

	public PessoaDTO setarDadosNaTabela(Integer id, String nome) {
		PessoaDTO pessoa = new PessoaDTO();
		pessoa.setId(id);
		pessoa.setNome(nome);
		return pessoa;
	}

	public PessoaDTO setarDadosNoCard(Integer id, String nome, String nomeMae, String nomePai, String rua,
			String numero, String bairro, String cidade, String estado, String celular1, String celular2, String email,
			String cpf, String sexo) {
		PessoaDTO pessoa = new PessoaDTO();
		pessoa.setId(id);
		pessoa.setNome(nome);
		pessoa.setNomeMae(nomeMae);
		pessoa.setNomePai(nomePai);
		pessoa.setRua(rua);
		pessoa.setNumero(numero);
		pessoa.setBairro(bairro);
		pessoa.setCidade(cidade);
		pessoa.setEstado(estado);
		pessoa.setCelular1(celular1);
		pessoa.setCelular2(celular2);
		pessoa.setEmail(email);
		pessoa.setCpf(cpf);
		pessoa.setSexo(sexo);
		return pessoa;
	}

}
