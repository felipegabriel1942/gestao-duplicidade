package br.com.gestaoduplicidade.utils;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class AbstractEntityBeans<T extends EntityInterface, ID extends Serializable>{

	
	private EntityManager manager;

	/**
	 * Classe de entidade que representa a implementação.
	 */
	private Class<T> entityClass;

	/**
	 * Recebe o tipo de classe de entidade que quem o implementa representa.
	 *
	 * @param entityClasss Classe de Entidate que o bean irá representar.
	 * @param facade
	 */
	public AbstractEntityBeans(final Class<T> entityClasss, final Class<? extends AbstractEntityBeans> facade) {
		this.entityClass = entityClasss;
	}

	/**
	 * A classe que implementa deve prover um EntityManager.
	 *
	 * @return EntityManager
	 */
	protected EntityManager getEntityManager() {
		return manager;
	}

	/**
	 * Fecha o EntityManager da classe implementadora.
	 */
	public void close() {
		if (getEntityManager() != null) {
			getEntityManager().close();
		}
		
	}
}
