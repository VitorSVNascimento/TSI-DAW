package br.tsi.distribuidora.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.tsi.distribuidora.dao.DAO;
import br.tsi.distribuidora.modelo.Produto;

@ViewScoped
@ManagedBean
public class ProdutoMB {
	
	private Produto produto = new Produto();
	private List<Produto> produtos;
	
	public void grava() {
		DAO<Produto> dao = new DAO<>(Produto.class);
		if (produto.getId() == null) {
			dao.adiciona(produto);
		}else {
			dao.altera(produto);
		}
		this.produto = new Produto();
		this.produtos = dao.listaTodos();
	}
	
	public void cancela() {
		this.produto = new Produto();
	}
	public void remove (Produto produto) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		DAO<Produto> dao = new DAO<>(Produto.class);
		this.produtos = dao.listaTodos();
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
	
	

}
