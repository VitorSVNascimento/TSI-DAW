package vsvn.daw.pizzaria.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import vsvn.daw.pizzaria.db.JPAUtil;
import vsvn.daw.pizzaria.models.Client;
import vsvn.daw.pizzaria.models.OrderInfo;



public class OrderDAO extends DAO<OrderInfo>{
	public OrderDAO(Class<OrderInfo> classe) {
		super(classe);
		// TODO Auto-generated constructor stub
	}

	public List<OrderInfo> getAllByClient(Client client){
		EntityManager em = new JPAUtil().getEntityManager();
			
		Query query = em.createQuery("from OrderInfo o where o.client = :client",OrderInfo.class);
		query.setParameter("client", client);
		@SuppressWarnings("unchecked")
		List<OrderInfo> itens = query.getResultList();
		
		return itens;

	}
	
	public List<OrderInfo> getAllNotServed(){
		EntityManager em = new JPAUtil().getEntityManager();
		
		Query query = em.createQuery("SELECT DISTINCT oi " +
                "FROM OrderInfo oi " +
                "JOIN FETCH oi.itens oiItems " +
                "WHERE  " +
                "oiItems.status = false", OrderInfo.class);
		
		@SuppressWarnings("unchecked")
		List<OrderInfo> itens = query.getResultList();
		
		return itens;
		
	}
	
	public List<OrderInfo> getDayOrders(){
		EntityManager em = new JPAUtil().getEntityManager();
		
		Query query = em.createQuery("FROM OrderInfo o WHERE o.orderDate = :thisdate");
		query.setParameter("thisdate", Calendar.getInstance());
		@SuppressWarnings("unchecked")
		List<OrderInfo> itens = query.getResultList();
		
		return itens;
		
	}
}
