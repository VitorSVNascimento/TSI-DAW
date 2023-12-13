package vsvn.daw.pizzaria.manageBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import vsvn.daw.pizzaria.dao.DAO;
import vsvn.daw.pizzaria.models.MenuItem;
import vsvn.daw.pizzaria.models.OrderInfo;
import vsvn.daw.pizzaria.models.OrderItem;

@ViewScoped
@ManagedBean
public class OrderInfoMB {

	private OrderInfo orderInfo = new OrderInfo();
	private OrderItem orderItem = new OrderItem();
	private Long idMenuItem;
	
	public void addItem() {
		DAO<MenuItem> daoMenuItem = new DAO<>(MenuItem.class);
		MenuItem menuItem = daoMenuItem.buscaPorId(idMenuItem);
		
		orderItem.setMenuItem(menuItem);
		orderItem.setTotal(orderItem.getTotal());
		
		orderInfo.getItens().add(orderItem);
		orderItem = new OrderItem();
	}
	
	public void save() {
		DAO<OrderInfo> dao = new DAO<>(OrderInfo.class);
		dao.adiciona(orderInfo);
		orderInfo = new OrderInfo();
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
	
	
	
}
