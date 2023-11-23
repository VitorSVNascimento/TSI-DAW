package br.tsi.daw.tp1.modelo;

public class Laudo {
	private int id;
	private String descricao, conclusao, status;
	private PedidoExame pedidoExame;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getConclusao() {
		return conclusao;
	}
	
	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public PedidoExame getPedidoExame() {
		return pedidoExame;
	}
	
	public void setPedidoExame(PedidoExame pedidoExame) {
		this.pedidoExame = pedidoExame;
	}
}
