package br.tsi.distribuidora.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.tsi.distribuidora.dao.UsuarioDAO;
import br.tsi.distribuidora.modelo.Usuario;

@SessionScoped
@ManagedBean
public class UsuarioMB {
	private Usuario usuario = new Usuario();

	public String loga() {
		UsuarioDAO dao = new UsuarioDAO();
		boolean existe = dao.validaCredencial(usuario);
		if (existe) {
			return "produto?faces-redirect=true";
		}else {
			return "login?faces-redirect=true";
		}
	}
	
	public String logout() {
		this.usuario = new Usuario();
		return "login?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isLogado() {
		return usuario.getLogin() != null;
	}
	
	

}
