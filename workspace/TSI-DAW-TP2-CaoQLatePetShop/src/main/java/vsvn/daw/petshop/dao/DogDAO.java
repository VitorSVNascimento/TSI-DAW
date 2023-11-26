package vsvn.daw.petshop.dao;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import vsvn.daw.petshop.models.Account;
import vsvn.daw.petshop.models.Dog;
public class DogDAO extends DAO<Dog> {

	public DogDAO(Class<Dog> objectClass) {
		super(objectClass);
		
	}
	
	public List<Dog> getDogsByOwner(Account account) {
		try (EntityManager em = super.getEntityManager()){
			
			if (account == null)
				throw new IllegalArgumentException("O dono não pode ser nulo!");
			
			Query query = em.createQuery("SELECT a FROM Dog a where a.account = :account",
					Dog.class);
			query.setParameter("account", account);
			
			@SuppressWarnings("unchecked")
			List<Dog> dogs = query.getResultList();
			
			return dogs;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
    }
		
	
	
	
}
