package br.tsi.daw.tarefas.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("tarefas");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}