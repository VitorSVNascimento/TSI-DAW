package vsvn.daw.petshop.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;
import vsvn.daw.petshop.db.JPAUtil;

public class DAO<T> {
	private Class<T> objectClass;
	
	public DAO(Class<T> objectClass){
		this.objectClass = objectClass;
	}
	
	public void insert(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}
	
	
	protected Class<T> getObjectClass() {
		return objectClass;
	}

	public void update(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(t));
		em.getTransaction().commit();
		em.close();
	}
	
	public T getById(Long id) {
		try(EntityManager em = getEntityManager()){
			
			return em.find(objectClass, id);
		}catch (Exception e) {
			return null;
		}
		
	}
	
	public List<T> getAll() {
		try(EntityManager em = getEntityManager()){
			CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(objectClass);
			query.select(query.from(objectClass));
			List<T> list = em.createQuery(query).getResultList();
			return list;
			
		}catch (Exception e) {
			return null;
		}
		
	}
	
	protected EntityManager getEntityManager() {
		return new JPAUtil().getEntityManager();
	}
	
}
