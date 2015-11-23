package br.com.projetooi.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DefaultController {
	
	protected EntityManager em;
	
	protected EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoOi-persistence-unit");
		if (em == null) {
			em = factory.createEntityManager();
		}
		return em;
	}



}
