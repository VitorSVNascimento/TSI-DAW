package br.tsi.daw.tarefas.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private final static String DATABASE_NAME = "tarefas";
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(DATABASE_NAME);

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}