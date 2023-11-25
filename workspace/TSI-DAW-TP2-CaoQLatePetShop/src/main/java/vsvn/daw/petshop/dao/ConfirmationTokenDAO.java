package vsvn.daw.petshop.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import vsvn.daw.petshop.db.JPAUtil;
import vsvn.daw.petshop.models.ConfirmationToken;
public class ConfirmationTokenDAO extends DAO<ConfirmationToken> {

	public ConfirmationTokenDAO(Class<ConfirmationToken> objectClass) {
		super(objectClass);
		
	}
	
	public ConfirmationToken getByToken(String token) {
		EntityManager em = new JPAUtil().getEntityManager();
		Query query = em.createQuery(" SELECT t FROM ConfirmationToken t where t.token = :token",
				ConfirmationToken.class);
		query.setParameter("token", token);
		ConfirmationToken token_data = (ConfirmationToken) query.getSingleResult();
		em.close();
		return token_data;
	}
}
