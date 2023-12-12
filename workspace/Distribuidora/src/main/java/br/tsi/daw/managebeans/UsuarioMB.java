package br.tsi.daw.managebeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.tsi.daw.dao.UsuarioDAO;
import br.tsi.daw.modelo.Usuario;

@SessionScoped
@ManagedBean
public class UsuarioMB {
	private Usuario usuario = new Usuario();

	public String loga() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		boolean existe = usuarioDAO.existe(usuario);
		//System.out.println(existe);
		if (existe) {
			return "produto?faces-redirect=true";
		}else {
			usuario = new Usuario();
			return "login?faces-redirect=true";
		}
	}
	
	public boolean isLogado() {
		return usuario.getLogin() != null;
	}
	
	public String logout() {
		usuario = new Usuario();
		return "login?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
