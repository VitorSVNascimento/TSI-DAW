package br.tsi.daw.managebeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.tsi.daw.dao.DAO;
import br.tsi.daw.modelo.Produto;

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
	
	public List<Produto> getProdutos() {
		DAO<Produto> dao = new DAO<>(Produto.class);
		this.produtos = dao.listaTodos();
		return produtos;
	}
	
	public void cancela() {
		this.produto = new Produto();
	}
	
	public void remove(Produto produto) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
//	public void comecaComMaiuscula(FacesContext fc, UIComponent component, Object value)
//			throws ValidatorException {
//		String valor = value.toString();
//		if (!valor.matches("[A-Z].*")) {
//			throw new ValidatorException(new FacesMessage(
//					"Deveria começar com letra maiúscula"));
//		}
//	}
}
