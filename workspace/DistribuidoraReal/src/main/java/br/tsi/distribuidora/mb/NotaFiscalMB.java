package br.tsi.distribuidora.mb;

import javax.faces.bean.*;

import br.tsi.distribuidora.dao.DAO;
import br.tsi.distribuidora.modelo.Item;
import br.tsi.distribuidora.modelo.NotaFiscal;
import br.tsi.distribuidora.modelo.Produto;

@ViewScoped
@ManagedBean
public class NotaFiscalMB {

		private NotaFiscal notaFiscal = new NotaFiscal();
		private Item item = new Item();
		private Long idProduto;
		
		public NotaFiscal getNotaFiscal() {
			return notaFiscal;
		}
		
		public void setNotaFiscal(NotaFiscal notaFiscal) {
			this.notaFiscal = notaFiscal;
		}
		
		public Item getItem() {
			return item;
		}
		
		public void setItem(Item item) {
			this.item = item;
		}
		
		public Long getIdProduto() {
			return idProduto;
		}
		
		public void setIdProduto(Long idProduto) {
			this.idProduto = idProduto;
		}
		
		public void guardaItem() {
			DAO<Produto> daoProduto = new DAO<>(Produto.class);
			Produto produto = daoProduto.buscaPorId(idProduto);
			item.setProduto(produto);
			item.setValorUnitario(produto.getPreco());
			item.setTotal(item.getTotal());
			notaFiscal.getItens().add(item);
			item.setNotaFiscal(notaFiscal);
			item = new Item();
		}
		
		public void gravaNotaFiscal() {
			DAO<NotaFiscal> daoNota = new DAO<NotaFiscal>(NotaFiscal.class);
			daoNota.adiciona(notaFiscal);
			notaFiscal = new NotaFiscal();
		}
				
}