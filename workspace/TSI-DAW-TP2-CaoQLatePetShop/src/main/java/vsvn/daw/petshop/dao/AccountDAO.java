package vsvn.daw.petshop.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import vsvn.daw.petshop.db.JPAUtil;
import vsvn.daw.petshop.models.Account;
public class AccountDAO extends DAO<Account> {

	public AccountDAO(Class<Account> objectClass) {
		super(objectClass);
		
	}
	
	public Account getByCpf(String cpf) {
		EntityManager em = new JPAUtil().getEntityManager();
		Query query = em.createQuery(" SELECT u FROM Account u where u.cpf = :cpf",
				Account.class);
		query.setParameter("cpf", cpf);
		Account token_data = (Account) query.getSingleResult();
		em.close();
		return token_data;
	}
	
	public Account loginVerify(Account account) {
		try (EntityManager em = getEntityManager()){
			if(account == null)
				return null;
			
			Query query = em.createQuery(" SELECT a FROM Account a where a.email = :email and a.password = :password ",
					Account.class);
			query.setParameter("email", account.getEmail());
			query.setParameter("password", account.getPassword());
			
			Account user = (Account)query.getSingleResult();
			System.out.println("Valido = "+user.getValid());
			if(!user.getValid())return null;
			
			user.setPassword(null);
			return user;
			
		} catch (Exception e) {
			//TODO Remove e.printStackTrace
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
