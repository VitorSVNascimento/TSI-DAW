package vsvn.daw.alunoseprofessores.modelo;



public class Professor {
	
	private Long id;
	private String nome;
	private String email;
	private String grau_formacao;
	public Professor() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getGrau_formacao() {
		return grau_formacao;
	}
	public void setGrau_formacao(String grau_formacao) {
		this.grau_formacao = grau_formacao;
	}
	@Override
	public String toString() {
		  StringBuilder professor = new StringBuilder();
			professor.append(String.format("\nID: %d |Nome: %s", id,nome));
			professor.append(String.format("\nEmail: %s",email));
			professor.append(String.format("\nForma��o: %s",grau_formacao));
			professor.append(String.format("\n---------------------------------------------------------\n"));
			return professor.toString();
	}
	
	
	
	
	
}
