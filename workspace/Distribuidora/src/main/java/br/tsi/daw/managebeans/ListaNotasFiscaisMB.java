package br.tsi.daw.managebeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.tsi.daw.dao.DAO;
import br.tsi.daw.modelo.NotaFiscal;

@ManagedBean
public class ListaNotasFiscaisMB implements Serializable  {
	private NotaFiscal notaFiscal = new NotaFiscal();
	private List<NotaFiscal> notasFiscais;
	
	public List<NotaFiscal> getNotasFiscais() {
		if (notasFiscais == null) {
			System.out.println("Carregando notas...");
			notasFiscais = new DAO<NotaFiscal>(NotaFiscal.class).listaTodos();
		}
		return notasFiscais;
	}

}
