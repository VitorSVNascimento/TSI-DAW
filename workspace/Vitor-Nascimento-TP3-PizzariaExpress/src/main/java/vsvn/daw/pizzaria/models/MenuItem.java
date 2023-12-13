package vsvn.daw.pizzaria.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class MenuItem {
		@Id
		@SequenceGenerator(
				name = "menu_item_id",
				sequenceName = "menu_item_seq",
				allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="menu_item_id")
		private Long id;
		private String name;
	    private String description;
	    private String size;
	    private String category;
	    private Double value;

	    // Getter and setter methods for each attribute
	    
	    
	    public Long getId() {
	    	return id;
	    }
	    
	    public void setId(Long id) {
	    	this.id = id;
	    }
	    
	    
	    public String getName() {
	        return name;
	    }


		public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getSize() {
	        return size;
	    }

	    public void setSize(String size) {
	        this.size = size;
	    }

	    public String getCategory() {
	        return category;
	    }

	    public void setCategory(String category) {
	        this.category = category;
	    }

	    public Double getValue() {
	        return value;
	    }

	    public void setValue(Double value) {
	        this.value = value;
	    }
}
