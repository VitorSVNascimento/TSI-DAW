package br.tsi.daw.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.NotBlank;



@Entity
public class Produto {
	@Id
	@SequenceGenerator(
			name="produto_id", 
			sequenceName="produto_seq",
			allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produto_id")
	private Long id;
	@NotBlank(message = "Produto deve ter um nome válido")
	private String nome;
	private String descricao;
	private Double preco;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
}
