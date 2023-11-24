package vsvn.daw.petshop.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
	private final static String DATABASE_NAME = "petshop";
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(DATABASE_NAME);

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
