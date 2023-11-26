package vsvn.daw.petshop.dao;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import vsvn.daw.petshop.db.JPAUtil;
import vsvn.daw.petshop.models.Account;
import vsvn.daw.petshop.models.Service;
public class ServiceDAO extends DAO<Account> {

	public ServiceDAO(Class<Account> objectClass) {
		super(objectClass);
		
	}
	
	public Service getByName(String name) {
		try(EntityManager em = new JPAUtil().getEntityManager()){
			Query query = em.createQuery(" SELECT s FROM Service s where s.name = :name",
					Service.class);
			query.setParameter("name", name);
			Service token_data = (Service) query.getSingleResult();
			em.close();
			return token_data;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<Service> getByName(String... names){
		
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
