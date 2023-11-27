package vsvn.daw.petshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Dog {
	@Id
	@SequenceGenerator(
			name = "dog_id",
			sequenceName = "dog_seq",
			allocationSize = 1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "dog_id")
	private Long id;
	@Size(min = 2, message = "O nome do cachorro deve conter no minimo 2 caracteres")
	private String name;
	@Size(min = 2, message = "O nome da raça do cachorro deve conter no minimo 2 caracteres")
	private String breed;
	@Pattern(regexp = "^(?i)(pequeno|medio|grande)$", message = "O porte do animal deve ser um entre: Pequeno,médio e grande")
	private String size;
	
	@ManyToOne
	private Account account;
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
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	
	
}
