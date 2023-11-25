package vsvn.daw.petshop.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class ConfirmationToken {
	@Id
	@SequenceGenerator(
			name = "token_id",
			sequenceName = "token_seq",
			allocationSize = 1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "token_id")
	private Long id;
	@Column(unique = true)
	private String token;
	@OneToOne()
	private Account account;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
