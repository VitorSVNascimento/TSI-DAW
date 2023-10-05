package br.tsi.daw.tarefas.model.dao;

import java.util.List;

import br.tsi.daw.tarefas.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class UsuarioDAO {
	EntityManager manager;

	public UsuarioDAO() {
		manager = new JPAUtil().getEntityManager();
	}

	public boolean validaLogin(Usuario usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Usuário não deve ser nulo");
		}
		Query query = manager.createQuery(" SELECT u FROM Usuario u where u.login = :login and u.senha = :senha ",
				Usuario.class);
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = query.getResultList();
		if (usuarios.size() == 0)
			return false;
		else
			return true;
	}
}
