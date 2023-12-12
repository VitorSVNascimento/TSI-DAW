package vsvn.daw.pizzaria.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Client {
		
		@Id
		@SequenceGenerator(
				name = "client_id",
				sequenceName = "client_seq",
				allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="client_id")
		private Long id;
	 	private String email;
	    private String fullName;
	    private String cpf;
	    private String phoneNumber;
	    private String token;
	    @OneToOne
	    private Address address ;


	    // Getter and setter methods for each attribute
	    
	    public Long getId() {
	    	return id;
	    }
	    
	    public void setId(Long id) {
	    	this.id = id;
	    }
	    
	    public String getEmail() {
	        return email;
	    }


		public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getFullName() {
	        return fullName;
	    }

	    public void setFullName(String fullName) {
	        this.fullName = fullName;
	    }

	    public String getCpf() {
	        return cpf;
	    }

	    public void setCpf(String cpf) {
	        this.cpf = cpf;
	    }

	    public String getPhoneNumber() {
	        return phoneNumber;
	    }

	    public void setPhoneNumber(String phoneNumber) {
	        this.phoneNumber = phoneNumber;
	    }

	    public Address getAddress() {
	        return address;
	    }

	    public void setAddress(Address address) {
	        this.address = address;
	    }

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}
	    
	    
	
}
