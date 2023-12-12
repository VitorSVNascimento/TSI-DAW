package vsvn.daw.pizzaria.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import vsvn.daw.pizzaria.db.JPAUtil;
import vsvn.daw.pizzaria.models.Employee;



public class EmployeeDAO {
	public Employee findEmployee(Employee employee) {
		EntityManager em = new JPAUtil().getEntityManager();
	
		Query query = em.createQuery
			("from Employee e where e.username= :username and e.password = :password");
		query.setParameter("username", employee.getUsername());
		query.setParameter("password", employee.getPassword());
		boolean encontrado = !query.getResultList().isEmpty();
		if(!encontrado) {
			em.close();
			return null;
			
		} 
		
		employee = (Employee)query.getSingleResult();
		return employee;
		
		
	}
}
