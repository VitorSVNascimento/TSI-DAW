package vsvn.daw.pizzaria.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class OrderItem {

	@Id
	@SequenceGenerator(
			name = "order_item_id",
			sequenceName = "order_item_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="order_item_id")
	private Long id;
	private Integer quantity;
	private  Double total;
	
	{
		total = 0.0;
	}
	
	@ManyToOne
	private MenuItem menuItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotal() {
		if (quantity != null && menuItem.getValue() != null)
			return total = quantity * menuItem.getValue();
		return total = 0.0;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	
}
