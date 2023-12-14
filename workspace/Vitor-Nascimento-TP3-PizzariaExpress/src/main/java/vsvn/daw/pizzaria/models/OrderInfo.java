package vsvn.daw.pizzaria.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OrderInfo {
		@Id
		@SequenceGenerator(
			name="order_info_id", 
			sequenceName="order_info_seq",
			allocationSize=1)
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order_info_id")
		private Long id;
		@Temporal(TemporalType.DATE)
	 	private Calendar orderDate = Calendar.getInstance();
		@ManyToOne
	    private Client client;
	    private double totalValue;
	    private Integer tableNumber;
	    @OneToMany(cascade = CascadeType.PERSIST)	
	    private List<OrderItem> itens = new ArrayList<OrderItem>();
	    // Getter and setter methods for each attribute

	    public Calendar getOrderDate() {
	        return orderDate;
	    }

	    public void setOrderDate(Calendar orderDate) {
	        this.orderDate = orderDate;
	    }

	    public Client getClient() {
	        return client;
	    }

	    public void setClient(Client client) {
	        this.client = client;
	    }

	    public double getTotalValue() {
	        return totalValue;
	    }

	    public void setTotalValue(double totalValue) {
	        this.totalValue = totalValue;
	    }

	    public Integer getTableNumber() {
	        return tableNumber;
	    }

	    public void setTableNumber(Integer tableNumber) {
	        this.tableNumber = tableNumber;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public List<OrderItem> getItens() {
			return itens;
		}

		public void setItens(List<OrderItem> itens) {
			this.itens = itens;
		}
		
		public Double getTotal() {
			Double total = 0.0;
			for(OrderItem o : itens)
				total+=o.getTotal();
			return total;
		}
		
		public List<OrderItem> getItensNotServed(){
			List<OrderItem> notServerd = new ArrayList<OrderItem>();
			for(OrderItem o : itens)
				if(!o.isStatus())
					notServerd.add(o);
			return notServerd;
		}
		
		public OrderItem serve(Long idItem) {
			for(OrderItem i : itens)
				if(i.getId() == idItem) {
					i.setStatus(true);
					return i;
				} 
			return null;		
		}
	    
}
