package vsvn.daw.pizzaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import vsvn.daw.pizzaria.db.JPAUtil;
import vsvn.daw.pizzaria.models.MenuItem;



public class MenuItemDAO extends DAO<MenuItem>{
	public MenuItemDAO(Class<MenuItem> classe) {
		super(classe);
		// TODO Auto-generated constructor stub
	}

	public List<MenuItem> getAllByCategory(){
		EntityManager em = new JPAUtil().getEntityManager();
			
		Query query = em.createQuery("SELECT c FROM MenuItem c ORDER BY c.category",MenuItem.class);
		
		@SuppressWarnings("unchecked")
		List<MenuItem> itens = query.getResultList();
		
		return itens;

	}
	
	public List<MenuItem> getAllIfAvaliability(){
		EntityManager em = new JPAUtil().getEntityManager();
		
		Query query = em.createQuery("SELECT c FROM MenuItem c WHERE c.availability = :aval ORDER BY c.category",MenuItem.class);
		query.setParameter("aval", true);
		@SuppressWarnings("unchecked")
		List<MenuItem> itens = query.getResultList();
		
		return itens;
		
	}
}
