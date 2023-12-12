package vsvn.daw.pizzaria.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {
		@Id
		@SequenceGenerator(
				name = "employee_id",
				sequenceName = "employee_seq",
				allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="employee_id")
		private Long id;
		private String username;
	    private String password;
	    private String userType;

	    // Getter and setter methods for each attribute
	    
	    
	    public Long getId() {
	    	return id;
	    }
	    
	    public void setId(Long id) {
	    	this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }


		public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getUserType() {
	        return userType;
	    }

	    public void setUserType(String userType) {
	        this.userType = userType;
	    }
}
