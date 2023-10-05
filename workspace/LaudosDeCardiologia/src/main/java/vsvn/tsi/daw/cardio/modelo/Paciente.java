package vsvn.tsi.daw.cardio.modelo;

import java.util.Calendar;

public class Paciente {
	private String cpf;
	private String nome;
	private String email;
	private String sexo;
	private Calendar datanascimento;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Calendar getDatanascimento() {
		return datanascimento;
	}
	
	public void setDatanascimento(Calendar datanascimento) {
		this.datanascimento = datanascimento;
	}
	
	
	
}
