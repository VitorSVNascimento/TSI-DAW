package br.tsi.distribuidora.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.tsi.distribuidora.modelo.Usuario;

public class UsuarioDAO {
	
	public boolean validaCredencial(Usuario usuario) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Query query = em.createQuery(
			"SELECT u from Usuario u where u.login = :pLogin and "
			+ "u.senha = :pSenha");
		query.setParameter("pLogin", usuario.getLogin());
		query.setParameter("pSenha", usuario.getSenha());
		
		boolean encontrado = !query.getResultList().isEmpty();
		return encontrado;
	}

}
