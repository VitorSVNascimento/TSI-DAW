package vsvn.daw.petshop.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Account {

	@Id
	@SequenceGenerator(
			name = "account_id",
			sequenceName = "account_seq",
			allocationSize = 1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "account_id")
	private Long id;
	@Size(min = 2, message = "O nome deve conter no minimo 2 caracteres")
	private String name;
	
	@Size(min = 11,max = 11,message = "O CPF deve conter 11 digitos")
	@Pattern(regexp = "^[0-9]+$")
	@Column(unique = true)
	private String cpf;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar birthday;
	private String email;
	private String password;
	private String telephone;
	private Boolean valid;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Calendar getBirthday() {
		return birthday;
	}
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	
	
	
}
