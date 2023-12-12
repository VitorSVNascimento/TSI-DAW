package vsvn.daw.pizzaria.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Address {
		@Id
		@SequenceGenerator(
				name = "address_id",
				sequenceName = "address_seq",
				allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="address_id")
		private Long id;
	  	private String street;
	    private String number;
	    private String neighborhood;
	    private String city;
	    private String state;
	    private String zipCode;
	    
	    

	    // Getter and setter methods for each attribute

	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getStreet() {
	        return street;
	    }

	    public void setStreet(String street) {
	        this.street = street;
	    }

	    public String getNumber() {
	        return number;
	    }

	    public void setNumber(String number) {
	        this.number = number;
	    }

	    public String getNeighborhood() {
	        return neighborhood;
	    }

	    public void setNeighborhood(String neighborhood) {
	        this.neighborhood = neighborhood;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    public String getState() {
	        return state;
	    }

	    public void setState(String state) {
	        this.state = state;
	    }

	    public String getZipCode() {
	        return zipCode;
	    }

	    public void setZipCode(String zipCode) {
	        this.zipCode = zipCode;
	    }

}
