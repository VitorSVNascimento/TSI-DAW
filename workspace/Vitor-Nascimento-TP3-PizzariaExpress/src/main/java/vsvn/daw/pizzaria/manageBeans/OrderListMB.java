package vsvn.daw.pizzaria.manageBeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import vsvn.daw.pizzaria.dao.DAO;
import vsvn.daw.pizzaria.dao.OrderDAO;
import vsvn.daw.pizzaria.models.Client;
import vsvn.daw.pizzaria.models.OrderInfo;
import vsvn.daw.pizzaria.models.OrderItem;

@ViewScoped
@ManagedBean
public class OrderListMB {

	private List<OrderInfo> orders;
	private List<OrderInfo> notServed;
	private List<OrderInfo> dayList;
		
	public List<OrderInfo> clientOrders(Long clientId){
		orders = new OrderDAO(OrderInfo.class).getAllByClient(new DAO<Client>(Client.class).buscaPorId(clientId));
		if (orders != null)
				return orders;
		return new ArrayList<OrderInfo>();		
	}

	public List<OrderInfo> getNotServed() {
		notServed = new OrderDAO(OrderInfo.class).getAllNotServed();
		return notServed;
	}

	public void setNotServed(List<OrderInfo> notServed) {
		this.notServed = notServed;
	}
	
	public List<OrderInfo> getDayOrder() {
		
		dayList = new OrderDAO(OrderInfo.class).getDayOrders();
		return dayList;
	}
	
	public Double getTotal() {
		Double total = 0.0;
		for(OrderInfo o : dayList)
			total += o.getTotal();
		return total;
			
	}
	
	
	public void serveOrderItem(Long idItem,Long idOrder) {
		 OrderInfo order = new OrderInfo();
		 for(OrderInfo o : notServed)
			 if(o.getId() == idOrder)
				 order = o;
		 DAO<OrderItem> dao = new DAO<>(OrderItem.class);
		 dao.altera(order.serve(idItem));
//		 this.notServed = getNotServed();
		 
	}

}
