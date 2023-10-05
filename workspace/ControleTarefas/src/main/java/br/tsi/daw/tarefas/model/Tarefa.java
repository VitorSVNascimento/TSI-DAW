package br.tsi.daw.tarefas.model;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Size;

@Entity
public class Tarefa {
	@Id
	@SequenceGenerator(
			name = "tarefa_id",
			sequenceName = "tarefa_seq",
			allocationSize = 1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tarefa_id")
	private Long id;
	@Size(min = 5, message = "O Limite de caracteres é 5")
	private String descricao;
	private boolean finalizado;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataFinalizacao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	
	
}
