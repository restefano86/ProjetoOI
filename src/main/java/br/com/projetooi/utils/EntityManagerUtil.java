package br.com.projetooi.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	 private static final String PU_NAME = "ProjetoOiPU";
	 private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PU_NAME);
	 private static ThreadLocal<EntityManager> entityManagerLocal = new ThreadLocal<EntityManager>();
	 
     public static EntityManager getEntityManager() {
             EntityManager em = entityManagerLocal.get();
             if (em == null)
             {
                 em = factory.createEntityManager();
                 entityManagerLocal.set(em);
             }
             return em;
     }
}
