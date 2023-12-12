package br.tsi.daw.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.tsi.daw.modelo.Usuario;

public class UsuarioDAO {
	public boolean existe(Usuario usuario) {
		EntityManager em = new JPAUtil().getEntityManager();
	
		Query query = em.createQuery
			("from Usuario u where u.login = :pLogin and u.senha = :pSenha");
		query.setParameter("pLogin", usuario.getLogin());
		query.setParameter("pSenha", usuario.getSenha());
		boolean encontrado = !query.getResultList().isEmpty();
		em.close();
		
		return encontrado;
	}
}
