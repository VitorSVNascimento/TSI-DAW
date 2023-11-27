package vsvn.daw.petshop.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
@Entity
public class Scheduling {
	
	@Id
	@SequenceGenerator(
			name = "service_id",
			sequenceName = "service_seq",
			allocationSize = 1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "service_id")
	private Long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(unique = true)
	private Calendar schedulingDate;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Dog dog;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Service> services = new ArrayList<Service>();
	
	private Float ammount;
	
	private String state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getSchedulingDate() {
		return schedulingDate;
	}

	public void setSchedulingDate(Calendar schedulingDate) {
		this.schedulingDate = schedulingDate;
	}

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public Float getAmmount() {
		return ammount;
	}

	public void setAmmount(Float ammount) {
		this.ammount = ammount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

}
