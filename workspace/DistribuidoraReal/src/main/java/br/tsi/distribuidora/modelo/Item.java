package br.tsi.distribuidora.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Item {
	@Id
	@SequenceGenerator(name="item_id", 
						sequenceName = "item_seq",
						allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
					generator = "item_id")
	private Long id;
	private Integer quantidade;
	private Double total = 0.0;
	private Double valorUnitario;
	
	@ManyToOne
	private Produto produto;

	@ManyToOne
	private NotaFiscal notaFiscal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getTotal() {
		if(quantidade != null && valorUnitario != null)
			return quantidade * valorUnitario;
		else return 0.0;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	
	
}
