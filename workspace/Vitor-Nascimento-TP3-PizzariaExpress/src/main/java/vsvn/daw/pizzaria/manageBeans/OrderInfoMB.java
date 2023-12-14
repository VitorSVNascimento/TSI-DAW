package vsvn.daw.pizzaria.manageBeans;

import java.util.Iterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import vsvn.daw.pizzaria.dao.DAO;
import vsvn.daw.pizzaria.models.Client;
import vsvn.daw.pizzaria.models.MenuItem;
import vsvn.daw.pizzaria.models.OrderInfo;
import vsvn.daw.pizzaria.models.OrderItem;

@ViewScoped
@ManagedBean
public class OrderInfoMB {

	private OrderInfo orderInfo = new OrderInfo();
	private OrderItem orderItem = new OrderItem();
	private Long idMenuItem;
	private Integer tableNumber;
	
	public void addItem() {
		DAO<MenuItem> daoMenuItem = new DAO<>(MenuItem.class);
		MenuItem menuItem = daoMenuItem.buscaPorId(idMenuItem);
		
		orderItem.setMenuItem(menuItem);
		orderItem.setTotal(orderItem.getTotal());
		
		orderInfo.getItens().add(orderItem);
		orderItem = new OrderItem();
	}
	
	public void sendNumber(Long clientID) {
		DAO<Client> dao = new DAO<Client>(Client.class);
		Client client = dao.buscaPorId(clientID);
		if(client != null)
			orderInfo.setClient(client);
		orderInfo.setTableNumber(tableNumber);
	}
	
	public void save() {
		DAO<OrderInfo> dao = new DAO<>(OrderInfo.class);
		Double total = 0.0;
		for(OrderItem o : orderInfo.getItens())
			total += o.getTotal();
		orderInfo.setTotalValue(total);
		dao.adiciona(orderInfo);
		orderInfo = new OrderInfo();
	}
	
	public void removeItem(Long idItem) {
	    Iterator<OrderItem> iterator = orderInfo.getItens().iterator();

	    while (iterator.hasNext()) {
	        OrderItem o = iterator.next();
	        if (o.getMenuItem().getId().equals(idItem)) {
	            iterator.remove(); // Usando o método remove do iterador
	        }
	    }
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public Long getIdMenuItem() {
		return idMenuItem;
	}

	public void setIdMenuItem(Long idMenuItem) {
		this.idMenuItem = idMenuItem;
	}

	public Integer getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(Integer tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	
	
}
