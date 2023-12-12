package vsvn.daw.pizzaria.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import vsvn.daw.pizzaria.db.JPAUtil;
import vsvn.daw.pizzaria.models.Address;



public class AddressDAO extends DAO<Address>{
	public AddressDAO(Class<Address> classe) {
		super(classe);
		// TODO Auto-generated constructor stub
	}

	public Address findAddress(Address address) {
		EntityManager em = new JPAUtil().getEntityManager();
	
		Query query = em.createQuery
			("from Address a where a.street= :street and a.number= :number and a.neighborhood= :neighborhood and a.zipCode= :zipCode");
		query.setParameter("street", address.getStreet());
		query.setParameter("number", address.getNumber());
		query.setParameter("neighborhood", address.getNeighborhood());
		query.setParameter("zipCode", address.getZipCode());
		boolean encontrado = !query.getResultList().isEmpty();
		if(!encontrado) {
			em.close();
			return null;
			
		} 
		
		address = (Address)query.getSingleResult();
		return address;
	}
}
