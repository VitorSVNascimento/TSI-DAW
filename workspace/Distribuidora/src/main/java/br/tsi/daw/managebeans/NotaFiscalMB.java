package br.tsi.daw.managebeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.tsi.daw.dao.DAO;
import br.tsi.daw.modelo.MenuItem;
import br.tsi.daw.modelo.NotaFiscal;
import br.tsi.daw.modelo.Produto;

@ManagedBean
@ViewScoped
public class NotaFiscalMB {
	private NotaFiscal notaFiscal = new NotaFiscal();
	private MenuItem item = new MenuItem();
	private Long idProduto;	
	
	public void guardaItem() {
		DAO<Produto> daoProduto = new DAO<>(Produto.class);
		Produto produto = daoProduto.buscaPorId(idProduto);
		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());	
		item.setTotal(item.getTotal());
		notaFiscal.getItens().add(item);
		item.setNotaFiscal(notaFiscal);
		item = new MenuItem();
	}
	
	public void grava() {
		DAO<NotaFiscal> dao = new DAO<>(NotaFiscal.class);
		dao.adiciona(notaFiscal);
		notaFiscal = new NotaFiscal();
	}
	
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public MenuItem getItem() {
		return item;
	}
	public void setItem(MenuItem item) {
		this.item = item;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}	
	
}
