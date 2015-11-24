package br.com.projetooi.model.usuario;

import javax.persistence.EntityManager;

import br.com.projetooi.model.GenericDAO;

public class UsuarioDAO extends GenericDAO<Integer, Usuario> {

	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager);
	}

}
