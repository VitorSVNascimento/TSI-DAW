package vsvn.daw.petshop.dao;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import vsvn.daw.petshop.models.Account;
import vsvn.daw.petshop.models.Dog;
import vsvn.daw.petshop.models.Scheduling;
public class SchedulingDAO extends DAO<Scheduling> {

	public SchedulingDAO(Class<Scheduling> objectClass) {
		super(objectClass);
		
	}
	
	@Transactional
	public List<Scheduling> getScheduled() {
		try (EntityManager em = super.getEntityManager()){
			
			Query query = em.createQuery("SELECT s FROM Scheduling s LEFT JOIN FETCH s.services WHERE s.state = :state AND s.schedulingDate >= CURRENT_DATE",
					Scheduling.class);
			query.setParameter("state", "Em aguardo");
			
			
			@SuppressWarnings("unchecked")
			List<Scheduling> scheduling= query.getResultList();
			
			return scheduling;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
    }
	
	@Transactional
	public List<Scheduling> getScheduledAdmin(Calendar date) {
		try (EntityManager em = super.getEntityManager()){
			
			Query query = em.createQuery("SELECT s FROM Scheduling s LEFT JOIN FETCH s.services WHERE s.state = :state AND s.schedulingDate >= :cur_date",
					Scheduling.class);
			query.setParameter("state", "Em aguardo");
			query.setParameter("cur_date", date);
			
			@SuppressWarnings("unchecked")
			List<Scheduling> scheduling= query.getResultList();
			
			return scheduling;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
		
	
	
	
}
