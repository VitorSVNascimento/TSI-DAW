package vsvn.tsi.daw.cardio.modelo;

import vsvn.tsi.daw.cardio.enums.CategoriaMedico;

public class Medico {
	private String crm;
	private String nome;
	private String senha;
	private CategoriaMedico categoria;
	private String titulacao;
	private String anoinicio;
	
	public String getCrm() {
		return crm;
	}
	
	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public CategoriaMedico getCategoria() {
		return categoria;
	}
	
	public void setCategoria(CategoriaMedico categoria) {
		this.categoria = categoria;
	}
	
	public String getTitulacao() {
		return titulacao;
	}
	          
	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}              
	
	public String getanoinicio() {
		return anoinicio;
	}
	
	public void setanoinicio(String matricula) {
		this.anoinicio = matricula;
	}

	@Override
	public String toString() {
		return "Medico [crm=" + crm + ", nome=" + nome + ", senha=" + senha + ", categoria=" + categoria
				+ ", titulacao=" + titulacao + ", anoinicio=" + anoinicio + "]";
	}
	
	
	
}
