package br.tsi.daw.tarefas.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Size;

;

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
