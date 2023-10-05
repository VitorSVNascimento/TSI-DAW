package br.tsi.daw.tarefas.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;

public class Usuario {
	@Id
	@SequenceGenerator(
			name = "usuario_id",
			sequenceName = "usuario_seq",
			allocationSize = 1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "usuario_id")
	private Long id;
	
	@NotBlank
	private String login;
	
	@NotBlank
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
