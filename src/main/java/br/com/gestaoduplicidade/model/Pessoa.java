package br.com.gestaoduplicidade.model;

import java.util.Calendar;


import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import br.com.gestaoduplicidade.dto.PessoaDTO;
import br.com.gestaoduplicidade.utils.EntityInterface;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pessoa")
@SqlResultSetMapping(name = "PessoaMapping", classes = @ConstructorResult(targetClass = PessoaDTO.class, columns = {
		@ColumnResult(name = "codigo", type = Long.class), @ColumnResult(name = "nome"),
		@ColumnResult(name = "nascimento", type = Calendar.class), @ColumnResult(name = "celular") }))
public class Pessoa implements EntityInterface<Pessoa> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Getter
	@Setter
	private Integer pkpessoa;

	@Getter
	@Setter
	private String nomepessoa;

	@Getter
	@Setter
	private Calendar nascimento;

	@Getter
	@Setter
	private String celular;

	@Override
	public int compareTo(Pessoa o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
