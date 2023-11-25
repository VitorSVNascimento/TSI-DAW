package vsvn.daw.petshop.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import vsvn.daw.petshop.models.Account;
import vsvn.daw.petshop.models.Employee;
public class EmployeeDAO extends DAO<Employee> {

	public EmployeeDAO(Class<Employee> objectClass) {
		super(objectClass);
		
	}
	
	public Employee loginVerify(Employee employee) {
		try (EntityManager em = getEntityManager()){
			if(employee == null)
				return null;
			
			Query query = em.createQuery(" SELECT e FROM Employee e where e.login = :login and e.password = :password ",
					Account.class);
			query.setParameter("login", employee.getLogin());
			query.setParameter("password", employee.getPassword());
			
			Employee user = (Employee)query.getSingleResult();
			
			user.setPassword(null);
			return user;
			
		} catch (Exception e) {
			//TODO Remove e.printStackTrace
			e.printStackTrace();
			return null;
		}
		
	}
	
	
}
