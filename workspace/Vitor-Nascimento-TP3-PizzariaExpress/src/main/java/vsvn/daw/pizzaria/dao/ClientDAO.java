package vsvn.daw.pizzaria.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import vsvn.daw.pizzaria.db.JPAUtil;
import vsvn.daw.pizzaria.models.Client;



public class ClientDAO extends DAO<Client>{
	public ClientDAO(Class<Client> classe) {
		super(classe);
		// TODO Auto-generated constructor stub
	}

	public Client findClientByEmailAndToken(Client client) {
		EntityManager em = new JPAUtil().getEntityManager();
	
		Query query = em.createQuery
			("from Client c where c.email= :email and c.token = :token");
		query.setParameter("email", client.getEmail());
		query.setParameter("token", client.getToken());
		boolean encontrado = !query.getResultList().isEmpty();
		if(!encontrado) {
			em.close();
			return null;
			
		} 
		
		client = (Client)query.getSingleResult();
		return client;
	}
	
	public Client findClientByEmail(Client client) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Query query = em.createQuery
				("from Client c where c.email= :email");
		query.setParameter("email", client.getEmail());
		boolean encontrado = !query.getResultList().isEmpty();
		if(!encontrado) {
			em.close();
			return null;
			
		} 
		
		client = (Client)query.getSingleResult();
		return client;
	}
	
	public boolean tokenExists(String token) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Query query = em.createQuery
				("from Client c where c.token= :token");
		query.setParameter("token",token);
		boolean encontrado = !query.getResultList().isEmpty();
		if(!encontrado) {
			em.close();
			return false;
			
		} 
		return true;
		
	}
}
